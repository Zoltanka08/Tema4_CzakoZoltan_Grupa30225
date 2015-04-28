/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4_czakozoltan_grupa30225;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Zoli
 */
public class Bank implements BankProc{
    
    private final static int TABLE_SIZE = 128;
 
    private Account[] table;
    private DefaultListModel list;
 
    Bank() {
        table = new Account[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
        this.list = new DefaultListModel();
    }
    
    private int hashCode(String IBAN)
    {
        int code = 0;
        for(int i=0;i<IBAN.length();i++)
        {
            code += IBAN.codePointAt(i);
        }
        
        return code % TABLE_SIZE;
    }
 
    public double readValue(String IBAN) {
        int hash = hashCode(IBAN);
        if (table[hash] == null)
            return -1;
        else {
            Account entry = table[hash];
            while (entry != null && !(entry.getIBAN().equals(IBAN)))
                entry = entry.getNext();
            if(entry != null)
                return entry.getValue();
        }
        return -1;
    }
    
    public int sizeOfHash()
    {
        return TABLE_SIZE;
    }
    
    public Account[] getTable()
    {
        return this.table;
    }
    
    public void writeAccount(int value, String IBAN){
        int hash = hashCode(IBAN);
        if (table[hash] == null)
            assert false: "Inexistent account!";
        else {
            Account entry = table[hash];
            while (entry.getNext() != null && !(entry.getIBAN().equals(IBAN)))
                entry = entry.getNext();
            if (entry.getIBAN().equals(IBAN))
                entry.setValue(value);
            else
                assert false: "Inexistent account!";
        }
    }
 
    
    public void addAccount(Account acc) throws ExistingAccountException {
        int hash = hashCode(acc.getIBAN());
        if (table[hash] == null)
        {
            table[hash] = acc;
            this.list.addElement(toString(acc));
        }
        else {
            Account entry = table[hash];
            while (entry.getNext() != null && !(entry.getIBAN().equals(acc.getIBAN())))
                entry = entry.getNext();
            if (entry.getIBAN().equals(acc.getIBAN()))
                throw new ExistingAccountException("IBAN: " + entry.getIBAN() + " already exists!");
            else
            {
                entry.setNext(acc);
                this.list.addElement(toString(acc));
            }
        }
    }
 
    public void removeAccount(String IBAN, int index) {
        int hash = hashCode(IBAN);
        if (table[hash] != null) {
            Account prevEntry = null;
            Account entry = table[hash];
            while (entry.getNext() != null && !(entry.getIBAN().equals(IBAN))) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getIBAN().equals(IBAN)) {
                if (prevEntry == null)
                    table[hash] = entry.getNext();
                else
                    prevEntry.setNext(entry.getNext());
                this.list.remove(index);
                }
            else
                assert false: "Inexistent Account!";
        }
    }

    @Override
    public int generateReport() {
        Document document = new Document();
        int index = 0;
        
        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("AccountReport.pdf"));
            document.open();
            document.add(new Paragraph("BANK ACCOUNT REPORT"));
            document.add(new Paragraph(" "));
            for(int i=0;i<TABLE_SIZE;i++) {
                
                if (table[i]!=null && table[i].getClass().equals(SavingAccount. class))
                {
                    SavingAccount entry = (SavingAccount) table[i];
                    while(entry!=null)
                    {
                        document.add(new Paragraph(++index + ". " + " SAVING ACCOUNT " + "IBAN:" + entry.getIBAN() + "; BALANCE:" + entry.getValue() + 
                                "; START DATE:" + entry.getStartingDate() + "; END DATE:" + entry.getEndingDate()));
                        entry = (SavingAccount) entry.getNext();
                    }
                }
                else
                {
                    Account entry = table[i];
                    while(entry!=null)
                    {
                        document.add(new Paragraph(++index + ". " + "IBAN: " + entry.getIBAN() + " BALANCE: " + entry.getValue()));
                        entry = entry.getNext();
                    }
                }
            }
            document.close(); // no need to close PDFwriter?
            return 0;
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
    
    public void bankInitializer(String fileName, int type)
    {
        FileInputStream fstream;
        double value;
        String IBAN;
        String PIN;
        Account acc = null;
        try {
            fstream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;
        
            while ((strLine = br.readLine()) != null)   {
                System.out.println (strLine);
                String[] tokens = strLine.split(" ");
                try
                {
                    IBAN = tokens[0];
                    value = Double.parseDouble(tokens[1]);
                    PIN = tokens[2];
                    switch(type)
                    {
                        case 0: acc = new Account(value,IBAN,PIN);break;
                        case 1: acc = new SpendingAccount(value,IBAN,PIN);break;
                        case 2: 
                            Date start = new Date();
                            Date end = new Date();
                            end.setDate(start.getDate()+200);
                            acc = new SavingAccount(value,IBAN,PIN,start,end);
                            break;
                    }
                    try {
                        if  (acc!=null) 
                        {
                            this.addAccount(acc);
                        }
                    }catch(ExistingAccountException ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                }catch(IndexOutOfBoundsException ex)
                {
                    
                }catch(NumberFormatException ex)
                {
                    
                }
            }

            br.close();  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    public Account findAccount(String IBAN) throws InexistentAccountException
    {
        int hash = hashCode(IBAN);
        if (table[hash] != null) {
            Account entry = table[hash];
            while (entry!= null && !(entry.getIBAN().equals(IBAN))) {
                entry = entry.getNext();
            }
            if (entry.getIBAN().equals(IBAN)) 
                return entry;
            else
                throw new InexistentAccountException("This account doesn't exists! Please contact the Bank!");
       }
       else
            throw new InexistentAccountException("This account doesn't exists! Please contact the Bank!");
    }
    
    public static void generateReceipt(Account acc, double value)
    {
        Document document = new Document();
        Date d = new Date();
        Random r = new Random();
        int number = r.nextInt(99999999)+10000;
        
        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("Chitanta.pdf"));
            document.open();
            document.add(new Paragraph("    *** BANK RECEIPT ***    "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" DATE: " + d));
            document.add(new Paragraph(" ATM: " + number));
            document.add(new Paragraph(" IBAN " + acc.getIBAN()));
            document.add(new Paragraph(" NUMERAR RETRAS " + value));
            document.add(new Paragraph(" SOLD DISPONIBIL " + acc.getBalance()));
            document.close(); // no need to close PDFwriter?
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void generateReceipt(Account acc)
    {
        Document document = new Document();
        Date d = new Date();
        Random r = new Random();
        int number = r.nextInt(99999999)+10000;
        
        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("Chitanta.pdf"));
            document.open();
            document.add(new Paragraph("    *** BANK RECEIPT ***    "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" DATE: " + d));
            document.add(new Paragraph(" ATM: " + number));
            document.add(new Paragraph(" IBAN " + acc.getIBAN()));
            document.add(new Paragraph(" SOLD DISPONIBIL " + acc.getBalance()));
            document.close(); // no need to close PDFwriter?
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public DefaultListModel getAccountList()
    {
        return this.list;
    }
    
    public String toString(Account acc)
    {
        String s = acc.getIBAN() + " " + acc.getValue();
        return s;
    }
    
}

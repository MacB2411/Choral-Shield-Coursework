import javax.swing.JOptionPane;
import java.io.*;
import java.util.Calendar;
public class SHOW
{ 
    private String MPM;
    private TICKET orderList[];
    int noOfOrders;
    int Total;
    FILEREADCSV orderFile;
    FILEWRITECSV fridayDataFile;
    
    
    public SHOW()
    {
        orderFile = new FILEREADCSV();
        fridayDataFile = new FILEWRITECSV();
    }
    
    public void processOrders() throws IOException{
        setUpOrderList();
        calcTotal();
        calcMPM();
        displayConcertData();
    }
     
    public void setUpOrderList() throws IOException{
        System.out.println("** Preparing to read data file.");
        String[] dataRows = orderFile.readCSVtable();
        
        noOfOrders = dataRows.length - 1;
         System.out.println("** " + noOfOrders + " rows read.\n\n");
        orderList = new ORDER[noOfOrders];
        
        for  (int i = 0; i < noOfOrders; i++) {
            orderList[i] = new ORDER();
            
            orderList[i].setOrderData(dataRows[i+1]);
        }
     }
     public void calcTotal() throws IOException{ 
         System.out.println("How much has been raised for charity \n");
         for  (int i = 0; i < noOfOrders; i++) {
            OrderList[i].displayDetails();
        }
    }
}
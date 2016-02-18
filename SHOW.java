import javax.swing.JOptionPane;
import java.io.*;
import java.util.Calendar;
public class SHOW
{ 
    private char MPM;
    private TICKET orderList[];
    int noOfOrders;
    FILEREADCSV orderFile;
    FILEREADCSV fridayDataFile;
    int totalCharity;
    
    public SHOW()
    {
        orderFile = new FILEREADCSV();
        fridayDataFile = new FILEWRITECSV();
    }
    
    public void processOrders() throws IOException{
        setUpOrderList();
        calcTotalAndMostPopularMethod();
        displayConcertData();
    }
     
    public void setUpOrderList() throws IOException{
         
        String[] dataRows = orderFile.readCSVtable();
        
         
        noOfOrders = dataRows.length - 1;
         
        orderList = new ORDER[noOfOrders];
        
        for  (int i = 0; i < noOfOrders; i++) {
            orderList[i] = new ORDER();
            
            orderList[i].setOrderData(dataRows[i+1]);
        }
     }
    }
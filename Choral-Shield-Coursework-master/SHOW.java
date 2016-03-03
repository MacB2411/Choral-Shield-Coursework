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
        //calcMPM();
        //displayTicketData();
    }
     
    public void setUpOrderList() throws IOException{
        System.out.println("** Preparing to read data file.");
        String[] dataRows = orderFile.readCSVtable();
        
        noOfOrders = dataRows.length - 1;
         System.out.println("** " + noOfOrders + " rows read.\n\n");
        orderList = new TICKET[noOfOrders];
        
        for  (int i = 0; i < noOfOrders; i++) {
            orderList[i] = new TICKET();
            
            orderList[i].setTicketData(dataRows[i]);
        }
     }
     public void calcTotal() throws IOException{ 
         for (int i = 0; i < noOfOrders; i++)
         { 
           if (orderList[i].getTicket().substring(0,1)=="W" ||
           orderList[i].getTicket().substring(0,1)== "T" ) {
               Total = Total + orderList[i].getNoOfTickets() * 5;
            }
            else{
                 Total = Total + orderList[i].getNoOfTickets() * 10;
            }
           
           }
        }
      
       }
       
      
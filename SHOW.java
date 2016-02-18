import javax.swing.JOptionPane;
import java.io.*;
import java.util.Calendar;
public class SHOW
{ 
    private String MPM;
    private TICKET orderList[];
    int noOfOrders;
    FILEREADCSV orderFile;
    FILEWRITECSV fridayDataFile;
    int totalCharity;
    
    public SHOW()
    {
        orderFile = new FILEREADCSV();
        fridayDataFile = new FILEWRITECSV();
    }
    
    public void processOrders() throws IOException{
        setUpOrderList();
        calcTotalAndPopularMethod();
        displayShowData();
    }
     
    public void setUpOrderList() throws IOException{
         
        String[] dataRows = orderFile.readCSVtable();
        
         
        noOfOrders = dataRows.length - 1;
         
        orderList = new TICKET[noOfOrders];
        
        for  (int i = 0; i < noOfOrders; i++) {
            orderList[i] = new TICKET();
            
            orderList[i].setTicketData(dataRows[i+1]);
        }
     }
     public void calcTotalAndPopularMethod() throws IOException{
        int count = 1, tempCount;
        char popular = orderList[0].getMethodOfPurchase();
        char temp = 0;
        charityTotalRaised = 0;
        String fridayOutputData = "";
        
        //go through every order.
        for (int i = 0; i < orderList.length ; i++){
            //add up the total.
            int toAdd = 0;
            switch(orderList[i].getTicketID()){
                case 'W':
                case 'T':
                    toAdd = orderList[i].getNoOfTickets() * 5;
                    break;
                case 'F':
                    toAdd = orderList[i].getNoOfTickets() * 10;
                    //add csv-ready data to a string to write to csv file. (+ newline delimiter)
                    fridayOutputData += orderList[i].getCSVDetails() + "\n";
                    break;
            }
            charityTotalRaised += toAdd;
            
            //find the most popular method
            temp = orderList[i].getMethodOfPurchase();
            tempCount = 0;
            for (int j = 1; j < orderList.length; j++){
                if (temp == orderList[j].getMethodOfPurchase()){
                    tempCount++;
                }
            }
            if (tempCount > count){
                popular = temp;
                count = tempCount;
            }
        }
        mostPopularMethod = popular;
        
        //write data to csv file
        fridayDataFile.writeCSVtable(fridayOutputData);
    }
    
    public void displayShowData(){
        System.out.println("Essell Academy Choral Shield " + Calendar.getInstance().get(Calendar.YEAR));
        
        String method = (mostPopularMethod == 'S') ?  "School" : "Website";
        
        System.out.println("The most popular method of sales is " + method);
        System.out.println("The total money raised for charity is £" + charityTotalRaised);
    }
}
    
    
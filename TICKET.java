import javax.swing.JOptionPane;
import java.io.*; 
public class TICKET
{  
    private String CustomerID;
    private String TicketID;
    private int NoOfTickets;
    private String MOP;
    private String Ticket;
    
    
    
   public TICKET()
  {
     CustomerID = "";
     TicketID = "";
     NoOfTickets = 0;
     MOP = "";
  }
  
   public void TicketDetails(String dataItems)
  {

   // unpack string of row data into fields
   String[] rowItems = dataItems.split(",");

   // store each data item as instance property
   CustomerID = rowItems[0];
   TicketID = rowItems[1];
   NoOfTickets = Integer.parseInt(rowItems[2]);
   MOP = rowItems[3];
  
      }
    
   public String writeDetails()
  {
     // join up data into a string to output as a row
     // use "," to separate csv columns
        String ticketData = "";
        ticketData = ticketData.concat(CustomerID);
        ticketData = ticketData.concat(",");
        ticketData = ticketData.concat(TicketID);
        ticketData = ticketData.concat(",");
        ticketData = ticketData.concat(Integer.toString(NoOfTickets));
        ticketData = ticketData.concat(",");
        ticketData = ticketData.concat(MOP);
        return ticketData;
    }
    
  public String getTicket()
  {
    return Ticket;
     
   }
    
     public void displayDetails()
 {
     // output basic details
     System.out.print("Essell Academy Choral Shield 2015 ");
     System.out.print(" The most popular method of sales is " + MOP );
     System.out.print(" The total money raised for charity is " + Total );
     System.out.println(Ticket);
        
    } 
    
    
    
    
    
    
    
    
    
}
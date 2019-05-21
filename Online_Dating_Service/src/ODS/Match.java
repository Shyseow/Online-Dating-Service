package ODS;
import java.util.*;
/**
 *File Name: Match.java
 *Purpose: Find matches, responders choose advertiser to send messages and advertiser to receive messages from responders 
 *
 *@author Seow Hui Yin
 *@version 1.0
 *@since Submission due date: 07/10/2018 
 */

public class Match {

    ArrayList<Customer> matching = new ArrayList<>(); //array list to store customer object
    Scanner kb = new Scanner(System.in);
    
    
    /**
     * Find all matching descriptions sought by advertisers
     * @param responder customer array
     * @param Rsp value of the responder member login
     */
    public void partnerSought(ArrayList<Customer> responder, int Rsp)   //responder member account 
    {
        matching.clear();  //removes all the matches elements
        for(int i=0;i<responder.size();i++)                                                       
        {
            if(responder.get(i).getCategory().equals("advertiser"))   //get matches with advertiser's partner sought detail          
            {
                PartnerAds tempSought = new PartnerAds();   //create an PartnerAds object for temporary store text advert detail                  
                Customer member = new Customer();           //create a customer object for temporary store responder detail
                member = responder.get(Rsp);                //responder detail matches with customer object
                tempSought = responder.get(i).getAdvert();  //temporary sought matches partner sought detail    
                
                if(member.getIncome()>=tempSought.getMinIncome())      //get responder income to match text advert min income
                {
                    if(member.getIncome()<=tempSought.getMaxIncome())  //get responder income to match text advert max income
                    {
                        if(member.getAge()>=tempSought.getMinAge())    //get responder age to match text advert min age
                        {
                            if(member.getAge()<=tempSought.getMaxAge())  //get responder age to match text advert max age
                            {
                                if(member.getGender().equals(tempSought.getGender()))   //get responder gender to match text advert gender
                                {
                                    matching.add(responder.get(i));       //add to array
                                    //System.out.println("Your matches: ");   //Print conformation 
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if(matching.isEmpty())    //if no matches found for responder
            System.out.println("No matches");  
        else                     //mathes found
            chooseMatch(matching);   //print out match advertiser detail    
    }
    
    /**
     *  Responder to choose to send reply messages to any of the matching advertisers
     * @param AdRspMatch array of all advertiser that matched with the user
     */
    public void chooseMatch(ArrayList<Customer> AdRspMatch)                        
    {
        for(int m=0;m<AdRspMatch.size();m++)                                    
        {   
            int advert = m+1;                                                    
            System.out.println("-----------------------------------------");
            System.out.println("\t\t Match:"+advert);  //match number for responder to select                                 
            System.out.println("-----------------------------------------");
            //Advertiser details
            System.out.println(" - Name: "+AdRspMatch.get(m).getLoginName());
            System.out.println(" - Gender: "+AdRspMatch.get(m).getGender());
            System.out.println(" - Age: "+AdRspMatch.get(m).getAge());
            System.out.println(" - Income: "+AdRspMatch.get(m).getIncome());       
        }
            System.out.println (" ");
            System.out.println ("Would you like to send a message? Y to send message or enter any key to log out: ");
            Scanner sendMsg = new Scanner(System.in);
            String selection = sendMsg.next();
            if (selection.equalsIgnoreCase("Y")){                                           
        System.out.println("Enter match number to message: ");
        int input = kb.nextInt();
        kb.nextLine();    //match number
        input = input-1;                                                        
        replyMsg(AdRspMatch.get(input));   //send messages to chosen advertiser 
            }
            else 
            {
             System.out.println ("Exiting... ");
             System.out.println("~~~~~~~~~~~~~~~~~~ Goodbye! ~~~~~~~~~~~~~~~~~~");}
    }
    
    /**
     * User responder enter messages and send to selected advertiser
     * @param match object of advertiser matched with
     */
    public void replyMsg(Customer match)                                      
    {
        System.out.println("====== Message to Matched Advertisers ======");
        System.out.println("Enter Message: ");
        String message = kb.nextLine();
        System.out.println("Enter Email: ");
        String email = kb.nextLine();
        System.out.println("Enter Contact No.: ");
        String contact = kb.nextLine();
        match.newReplyMsg("Message : " + message + "\n" + "Email :" +email + "\n"+ "Contact :" +contact);  
        System.out.println("~~~~~~~~~~~~~~~ Message Sent! ~~~~~~~~~~~~~~");
        System.out.println(" ");
        
    }
    
    /**
     * Print a list of reply messages, which they can delete or keep to re-read
     * @param advertiser customer object array
     * @param Ads value of the advertiser member login
     */
    public void mailBox(ArrayList<Customer> advertiser, int Ads)  //advertiser member account and view inbox messages
    {
        ArrayList<String> inbox = new ArrayList<>();
        inbox = advertiser.get(Ads).getMessage();
        if(inbox.isEmpty())      //no messages in advertiser mailbox
        {
            System.out.println("No messages");      //if advertiser has no messages
        }
        else        
        {    
            for(int i=0;i<inbox.size();i++)  //advertiser's inbox   
            {
                int mailNo = i+1;
                System.out.println("=============== "+ advertiser.get(Ads).getLoginName()+ "'s Inbox ============");
                System.out.println("Message " + mailNo);  
                System.out.println(inbox.get(i));
                System.out.println("+----------------------------------------------------------------------------+");
                System.out.println("|This is the message from your admire!                                       |");
                System.out.println("|Please contact your desire partner via email/contact provided in the message|");
                System.out.println("+----------------------------------------------------------------------------+");
            }
                boolean logout = false;
                while(logout==false){  //quit if input is 99
                    System.out.println("Enter message number to delete or 99 to log out: ");
                    int msgNo = kb.nextInt();     //message number selected
                    msgNo = msgNo-1;
                        if(msgNo == 98)
                            logout = true;   //logout
                        else
                        {
                            inbox.remove(msgNo);     //remove element input by advertiser
                            System.out.println("Message Deleted");
                        }
                }
        }
    }
}

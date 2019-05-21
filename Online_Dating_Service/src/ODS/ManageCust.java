package ODS;
import java.util.*;

/**
 *File Name: ManageCust.java
 *Purpose: Manage a list of customer, array of customer object that store all user input information 
 *         that need to perform several operations: add new member, delete a member, existing member login 
 *         to view or send message, display all detail of advertisers and responders
 *
 *@author Seow Hui Yin
 *@version 1.0
 *@since Submission due date: 07/10/2018
 */

public class ManageCust {
 
    ArrayList<Customer> datingService = new ArrayList<>();  //array list to store all customer objects
    Scanner kb = new Scanner(System.in);
    
    /**
     * Create a new member to the dating service   
     */
    public void newMember(){
        {
        Customer cust = new Customer();
        cust.newSignUp();
        datingService.add(cust);     //Add a new member to array list
        }
    {
       {
         boolean quit = false;
         while(quit==false) 
        {    
         System.out.println("Enter 1 to continue or 99 to logout: ");
         int input = kb.nextInt();    
         if(input == 99)
         quit = true;  //quit
         else
         {
          Customer cus = new Customer();
          cus.newSignUp();
          datingService.add(cus);
         }
         }
       }
    }
    }
         
 
    /**
     * Check login name and password input matches and allow user member to login
     * @param nameList Customer object array
     */
    public void Login(ArrayList<Customer> nameList)
    {
        Scanner keyboard = new Scanner(System.in);
        Match messages = new Match();
        boolean loggedIn = false;
        int member = 0;
        System.out.println(" "); 
        System.out.println("   ============ Member Login ============");   
        System.out.println("Enter Your Login Name: ");
        String user = keyboard.next();
        System.out.println("Enter Your Password: ");
        String pass = keyboard.next();
        System.out.println("   ======================================");
        for(int i=0;i<nameList.size();i++)     
        {   
                    //input login name and password equals to customer object
            if((nameList.get(i)).getDefaultPwd().equals(pass)&& nameList.get(i).getLoginName().equals(user))
            {
                System.out.println("\t\tLogged In!");        //successful login
                loggedIn = true;
                member = i;      //element of the user logged in
                
                    if(nameList.get(member).getCategory().equals("responder"))      //if login user is responder   
                    {
                        messages.partnerSought(nameList,member);        //search for matches
                    }
                    else      //if login user is advertiser
                    {
                    
                        messages.mailBox(nameList,member);        //access the inbox
                    }    
            }
        }
            
        if(loggedIn == false)   //login fail
        {
            System.out.println("Incorrect Login Name or Password");
        }
    }
    
    /**
     * Print the details of all customers registered with the service
     * @see Customer
     */
    public void printAllMember()
    {
        int count = 0;
        System.out.println(" ");
        System.out.println("-----------------------------------------");
        System.out.println("========== Printing All Customers =========");
        System.out.println("-----------------------------------------");
        for(int i=0;i<datingService.size();i++)     //loop through all customer objects in array list
        {
            {
                System.out.println(" Name: "+datingService.get(i).getLoginName());       //prints information of all customers
                System.out.println(" Age: "+datingService.get(i).getAge());
                System.out.println(" Gender: "+datingService.get(i).getGender());
                System.out.println(" Income: "+datingService.get(i).getIncome());
                System.out.println(" Category: "+datingService.get(i).getCategory());
                System.out.println("    ------------- ODS -------------");
                count=count+1;      //count the amount of all customers
            }
        }
        System.out.println("     Total Amount of All Members: "+count);      //total amount of all registered customers
        System.out.println("-----------------------------------------");
        System.out.println(" ");
    }
    

    /**
     * Allow user login to the dating service after validate 
     * 
     */
    public void exgMember()
    {
        Login(datingService);        //customer is sent to be logged in in login class
    }
    
    /**
     * Delete an existing customer from the dating service
     */
    public void deleteMember()
    {
        boolean found = false;
        System.out.println(" ");
        System.out.println("-----------------------------------------");
        System.out.print("Enter Login Name to be Deleted: ");
        String input = kb.next();
        for(int i=0;i<datingService.size();i++)
        {
            if(datingService.get(i).getLoginName().equals(input))       //user input matches registered login name
            {
                datingService.remove(i);        //delete that user
                System.out.println("       >>>>>>> User Deleted <<<<<<<");
                found = true;
                break;
            }
        }
            if(!found)        //input login name not valid
            {
                System.out.println("       >>>> That user does not exist <<<<");
            }
        System.out.println("-----------------------------------------");        
    }
    
    /**
     * Print the details of all advertisers registered with the service
     * @see Customer
     */
    public void displayAdvertisers()
    {
        int count = 0;
        System.out.println(" ");
        System.out.println("-----------------------------------------");
        System.out.println("========== Printing Advertisers =========");
        System.out.println("-----------------------------------------");
        for(int i=0;i<datingService.size();i++)     //loop through all customer objects in array list
        {
            if(datingService.get(i).getCategory().equals("advertiser"))      //customer category is responder
            {
                System.out.println(" - Name: "+datingService.get(i).getLoginName());       //print information of advertisers
                System.out.println(" - Age: "+datingService.get(i).getAge());
                System.out.println(" - Gender: "+datingService.get(i).getGender());
                System.out.println(" - Income: "+datingService.get(i).getIncome());
                System.out.println("    ------------- Ads -------------");
                count=count+1;      //count the amount of advertisers
            }
        }
        System.out.println("     Total Amount of Advertisers: "+count);      //print total amount of advertisers
        System.out.println("-----------------------------------------");
        System.out.println(" ");
    }
    
    /**
     * Print the details of all responders registered with the service
     * @see Customer
     */
    public void displayResponders()
    {
        int count = 0;
        System.out.println(" ");
        System.out.println("-----------------------------------------");
        System.out.println("========== Printing Responders ==========");
        System.out.println("-----------------------------------------");
        for(int i=0;i<datingService.size();i++)     //loop through all customer objects
        {
            if(datingService.get(i).getCategory().equals("responder"))     //customer category is responder
            {
                System.out.println(" Name: "+datingService.get(i).getLoginName());       //print information of responders
                System.out.println(" Age: "+datingService.get(i).getAge());
                System.out.println(" Gender: "+datingService.get(i).getGender());
                System.out.println(" Income: "+datingService.get(i).getIncome());
                System.out.println("    ----------- Respond -----------");

                count=count+1;      //count amount of responders
            }
        }
        System.out.println("     Total Amount of responders: "+count);      //print total amount of responders
        System.out.println("-----------------------------------------");
        System.out.println(" ");
        
    }

    /**
     *  Print student detail
     */
    public void displayStudentDetails()
    {
        System.out.println("Name: Seow Hui Yin");
        System.out.println("Student No: 33255186");
        System.out.println("Mode of Enrolment: External");
        System.out.println("Tutor Name: Sarita Singh");
        System.out.println("Tutorial attendance day and time: Monday from 7pm to 10.30pm\n"); 
    }
}
    





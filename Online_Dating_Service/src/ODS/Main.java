package ODS;
import java.util.*;

/**
 *File Name: Main.java
 *Purpose: Print out Menu and perform task according to user input option
 *Input: Integer 1 to 7
 *Output: Print result if selection within 1-7 else print invalid input
 *
 *@author Seow Hui Yin
 *@version 1.0
 *@since Submission due date: 07/10/2018 
 */
public class Main {
       
     /**
     * Main method begins program execution, and print out user choice result
     * @param args
     * @see ManageCust 
     */   
    public static void main(String[] args) {
     
        boolean quit = false;
        ManageCust service = new ManageCust(); //create an ManageCust object and assign it to service
        Scanner keyboard = new Scanner(System.in);
        
        
        service.displayStudentDetails();
        
        System.out.println("============================================");
        System.out.println("------Welcome to Online Dating Service------");
        System.out.println("============================================");
               
        while(quit != true)
        {
            //menu selection
        System.out.println("1 -- New Member SignUp");
        System.out.println("2 -- Print all Members");
        System.out.println("3 -- Member Login");
        System.out.println("4 -- Delete an Account");
        System.out.println("5 -- Details of all Advertisers");
        System.out.println("6 -- Detials of all Responders");
        System.out.println("7 -- Quit :");
        System.out.println("============================================");
        System.out.print("Enter your option here [1-7]: ");
        
        int choice = keyboard.nextInt();     //input selection
            switch(choice)
            {
                case 1:
                    service.newMember(); //create a new member
                    break;
                case 2:
                    service.printAllMember(); //print all customers in the service
                    break;
                case 3:
                    service.exgMember(); //member login
                    break;
                case 4:
                    service.deleteMember(); //delete an account
                    break;
                case 5:
                    service.displayAdvertisers(); //print the details of all advertisers
                    break;
                case 6:
                    service.displayResponders();  //print the details of all responders
                    break;
                case 7:
                    quit = true; //quit program
                    System.out.println("Goodbye! You are exiting dating service");
                    break;
                default:
                    System.out.println("Invalid Input. Please select 1-7");   //invalid input
                    break;
            }
        }
   
    }
}
   


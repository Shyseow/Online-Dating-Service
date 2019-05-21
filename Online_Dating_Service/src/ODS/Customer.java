package ODS;
import java.util.*;
import java.security.SecureRandom;

/**
 *File Name: Customer.java
 *Purpose: Store detail of customer
 *
 *@author Seow Hui Yin
 *@version 1.0
 *@since Submission due date: 07/10/2018 
 */
public class Customer {
 
    private String gender,loginName,loginPwd,pwdChar,defPwd,category;
    private int age;
    private double income;
    private final SecureRandom random = new SecureRandom(); //random object will produce secure random numbers
    PartnerAds advert = new PartnerAds(); //create an PartnerAds object and assign it to advert
    private final ArrayList<String> listOfMsg = new ArrayList<>(); // create a new ArrayList of Strings to store list of message
    Scanner kb = new Scanner(System.in); //crete a scanner onject to obtain input from command window
    boolean quit = false;

    /**
     * To test the input based on the requested type
     * @param testStr string to test
     * @param type to test integer,double
     * @return true if the string was converted successfully, else false
     * @throws NumberFormatException
     */  
    public Boolean isType(String testStr, String type) {
                    try {
                            if (type.equalsIgnoreCase("double")) {
                                    Double.parseDouble(testStr);
                            } else if (type.equalsIgnoreCase("int")) {
                                    Integer.parseInt(testStr);
                            }
                            return true;
                    } catch(NumberFormatException e) {
                            return false;
                    }
            }

    /**
    * Ask user repeatedly until the input type is correct 
    * @param inputInt String to prompt to the user.
    * @return Final value of the accepted input, integer
    */
    public int askInputInt(String inputInt) {
                    Boolean error = false;
                    String userInp = "";
                    do {
                            System.out.print(inputInt);
                            userInp = kb.nextLine();
                            if (!this.isType(userInp, "int")) {
                                    error = true;
                                    System.err.println("Error: must be a whole number.");
                            } else {
                                    error = false;
                            }
                    } while (error == true);
                    return Integer.parseInt(userInp);
            }

    /**
    * Ask user repeatedly until the input type is correct 
    * @param inputDouble String to prompt to the user.
    * @return Final value of the accepted input, double
    */
    public double askInputDouble(String inputDouble) {
                    Boolean error = false;
                    String userInp = "";
                    do {
                            System.out.print(inputDouble);
                            userInp = kb.nextLine();
                            // validate:
                            if (!this.isType(userInp, "double")) {
                                    System.err.println("Error: must be a number.");
                                    error = true;
                            } else {
                                    error = false;
                            }

                    } while (error == true);
                    return Double.parseDouble(userInp);
            }

    /**
     * Generate random password for new member as default password
     */
    public void GenRandomPwd()    
    {
        pwdChar = "1234567890@#+abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ";   //password character string to random generate
        defPwd = "";      
        for(int i=0; i<5; i++)      
        {
            int index = (int)(random.nextDouble()*pwdChar.length());       //get a random index in the pwdChar string
            defPwd += pwdChar.substring(index, index+1);                   //add random index to defPwd string
        }
        loginPwd = defPwd;       //save as default login password
    }        
        
    /**
     * Create a new member 
     */
    public void newSignUp()
    {

        System.out.println(" ~~~~~~~~~~~~ New Member SignUp ~~~~~~~~~~~~");
        System.out.print("Enter your Login Name: ");        //user choices a login name
        String n = kb.nextLine();
        setLoginName(n);        //saves login name
        
        while(quit != true){
        System.out.println("              -----------------");
        System.out.print("Enter Your Gender(male/female): ");     //user enters their gender
        String g = kb.nextLine();

        switch (g.toLowerCase()){
            case ("m"):
                setGender(g);
                quit=true;
                break;
            case ("f"):
                setGender(g);
                quit=true;
                break;
            default:
              System.err.println("Please enter 'm' or 'f' (NOT CASE SENSITIVE)");
              break;} } 
        
        System.out.println("              -----------------");
        int y = askInputInt("Enter your Age: "); 
        setAge(y);      //saves age

        System.out.println("              -----------------"); 
        double m = askInputDouble("Enter your Monthly Income: "); //user enters their income
        setIncome(m);       //saves income  
        
        GenRandomPwd();    //generate random password
        String pw = getDefaultPwd();
        System.out.println("              -----------------");
        System.out.println("Your default password is: " + pw);     //presents user with their password
        
        System.out.println("              -----------------"); 
            System.out.println("Register as Advertiser or Responder");
            System.out.println("Please enter 'a' or 'r' (NOT CASE SENSITIVE)");
            System.out.print("-> ");
            String input = kb.next();     //input of either advert(a advertiser) or respond(a responder)
                switch(input.toLowerCase())
                {
                    case "a":      //if advertiser is selected
                        setCategory("advertiser");       //set catergory to advertisement
                        PartnerAds tempAd = new PartnerAds();     //temporary ad object
                        tempAd.textAdvert();     //create a new advertisement
                        setAdvert(tempAd);      //save temporary ad object
                        break;
                
                    case "r":     //if responder is selected
                        setCategory("responder");       //set category to responder
                        System.out.println("-------------------------------------------");
                        System.out.println(" ~~ Successfully registered as Responder ~~");
                        System.out.println("# Your Responder account has been created #");
                        System.out.println("===========================================");
                        System.out.println(" ");
                        break;
                        
                    default:        //invalid input
                        System.out.println("### Invalid account type, please try again ###");
                }
            
    }
    
    
    /**
     * Set new registered member gender
     * @param sex gender of new member
     */
    public void setGender(String sex)
    {
        this.gender=sex;
    }
    
    /**
     * Get new registered member gender value
     * @return gender
     */
    public String getGender()
    {
        return gender;
    }
    
    /**
     * Set new registered member login name
     * @param name login name of new member
     */
    public void setLoginName(String name)
    {
        this.loginName=name;
    }
    
    /**
     * Get new registered member login name value
     * @return login name
     */
    public String getLoginName()
    {
        return loginName;
    }
    
    /**
     * Set new registered member income
     * @param x age of new member
     */
    public void setAge(int x)
    {
        this.age = x;
    }
    
    /**
     * Get new registered member age value
     * @return age
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * Set new register member income
     * @param x income of new member
     */
    public void setIncome(double x)
    {
        this.income = x;
    }
    
    /**
     * Get new register member income value
     * @return income
     */
    public double getIncome()
    {
        return income;
    }
    
    /**
     * Set category as advertiser or responder
     * @param x category of new member
     */
    public void setCategory(String x)
    {
        this.category = x;
    }
    
    /**
     * Get member category as advertiser or responder value
     * @return category
     */
    public String getCategory()
    {
        return category;
    }
    
        /**
     * To store a message 
     * @param msg message
     */
    public void newReplyMsg(String msg)
    {
        listOfMsg.add(msg);
    }
    
    /**
     * Get list of messages value
     * @return listOfMsg
     */
    public ArrayList<String> getMessage()
    {
        return listOfMsg;
    }
    
    /**
     * Set the PartnerAds object
     * @param advert PartnerAds object
     */
    public void setAdvert(PartnerAds advert)
    {
        this.advert = advert;
    }
    
    /**
     * Get the PartnerAds object value
     * @return PartnerAds object
     */
    public PartnerAds getAdvert()
    {
        return advert;
    }
    
    /**
     * Get login password value
     * @return login password
     */
    public String getDefaultPwd()
    {
        return loginPwd;
    }
            
}

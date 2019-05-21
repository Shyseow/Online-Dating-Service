package ODS;
import java.util.*;

/**
 *File Name: PartnerAds.java
 *Purpose: Store the text advert created by advertiser, a description of partner sought
 *
 *@author Seow Hui Yin
 *@version 1.0
 *@since Submission due date: 07/10/2018
 */
public class PartnerAds {
        private int minAge, maxAge;
        private double minIncome, maxIncome;
        private String gender;  
        Scanner kb = new Scanner(System.in);
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
     * Create an advert text, description of partner sought
     */    
    public void textAdvert()
    {

       System.out.println("======== Partner Sought Details ========");
       int x = askInputInt("Enter minumun age: ");   
       setMinAge(x);        //set minimum age
       
       x = askInputInt("Enter max age: "); 
       setMaxAge(x);        //set maximum age
       
       double m = askInputDouble("Enter minimum income: "); 
       setMinIncome(m);     //set minimum income
       
       m = askInputDouble("Enter max income: "); 
       setMaxIncome(m);     //set maximum income
       
       while(quit != true){
       System.out.print("Prefered gender(male/female): ");        
       String y = kb.next();
       
               switch (y.toLowerCase()){
            case ("m"):
                setGender(y); //set gender
                quit=true;
                break;
            case ("f"):
                setGender(y); //set gender
                quit=true;
                break;
            default:
              System.err.println("Please enter 'm' or 'f' (NOT CASE SENSITIVE)");
              System.err.println("->->->->->->->->->->->->->->->->->->->->->->");
              break;} } 

       System.out.println("----------------------------------------");
       System.out.println(" ~Successfully registered as Advertiser~");
       System.out.println("# Your Advert Account has been Created #");
       System.out.println("========================================");
       System.out.println(" ");
    }
    
    /**
     * Set prefer minimum age
     * @param x minimum age 
     */
    public void setMinAge(int x)
    {
        this.minAge = x;
    }
    
    /**
     * Get prefer minimum age value
     * @return minimum age
     */
    public int getMinAge()
    {
        return minAge;
    }
    
    /**
     * Set prefer maximum age
     * @param x maximum age
     */
    public void setMaxAge(int x)
    {
        this.maxAge=x;
    }
    
    /**
     * Get prefer maximum age value
     * @return maximum age
     */
    public int getMaxAge()
    {
        return maxAge;
    }
    
    /**
     * Set prefer minimum income
     * @param x minimum income
     */
    public void setMinIncome(double x)
    {
        this.minIncome = x;
    }
    
    /**
     * Get prefer minimum income value
     * @return minimum income
     */
    public double getMinIncome()
    {
        return minIncome;
    }
    
    /**
     * Set prefer maximum income
     * @param x maximum income
     */
    public void setMaxIncome(double x)
    {
        this.maxIncome = x;
    }
    
    /**
     * Get prefer maximum income value
     * @return maximum income
     */
    public double getMaxIncome()
    {
        return maxIncome;
    }
    
    /**
     * Set prefer gender
     * @param x gender
     */
    public void setGender(String x)
    {
        this.gender=x;
    }
    
    /**
     * Get prefer gender value
     * @return gender
     */
    public String getGender()
    {
        return gender;
    }
    
}

public class BankDetails {

    /**
+     * This is the main function of the BankDetails class.
+     * It is the entry point of the program.
+     * 
+     * @param args - an array of strings that contains command line arguments
+     */
     public static void main(String args[]){
        // Create an instance of the AccountHolder class and initialize it with various parameters
        AccountHolder accountHolder = new AccountHolder("talha", 123456, 123, 2000, "SBI", "Delhi", "SBI123");
       
        // Call the bank_details method to display the bank details
        accountHolder.bank_details();
       AccountHolder a = new AccountHolder("talha", 123456, 123, 2000, "SBI", "Delhi", "SBI123");
        a.bank_details();
     }

}

/**
 * interface
 */

/**
+ * Interface Bank defines the method bank_details which is used to display the bank details of an account holder.
+ */
interface Bank{
   public void bank_details();  // This method is used to display the bank details of an account holder.
}


/**
+ * AccountHolder class implements the Bank interface. It holds the bank details of an account holder
+ * and provides the implementation for the bank_details method defined in the Bank interface.
+ * 
+ * @author [Your Name]
+ * @version [Version]
+ */
 class AccountHolder implements Bank{
    // Bank details of an account holder
     public String bank_name;
     public String bank_branch;
     public String bank_ifsc;
     public String name;
     public int account_number;
     public int pin;
     public double balance;
 
    /**
+     * Constructor for the AccountHolder class. It initializes the instance variables with the provided values.
+     * 
+     * @param name - the name of the account holder
+     * @param account_number - the account number of the account holder
+     * @param pin - the pin of the account holder
+     * @param balance - the balance of the account holder
+     * @param bank_name - the name of the bank
+     * @param bank_branch - the branch of the bank
+     * @param bank_ifsc - the ifsc code of the bank
+     */
     public AccountHolder(String name, int account_number, int pin, double balance, String bank_name, String bank_branch, String bank_ifsc){
         this.name = name;
         this.account_number = account_number;
         this.pin = pin;
         this.balance = balance;
         this.bank_name = bank_name;
         this.bank_branch = bank_branch;
         this.bank_ifsc = bank_ifsc;
 
     }
 
    /**
+     * This method is used to display the bank details of an account holder.
+     * It prints the bank name, bank branch, and bank ifsc code.
+     */
     public void bank_details(){
         System.out.println("Bank name is: " + this.bank_name);
         System.out.println("Bank branch is: " + this.bank_branch);
         System.out.println("Bank ifsc is: " + this.bank_ifsc);
     }
 }

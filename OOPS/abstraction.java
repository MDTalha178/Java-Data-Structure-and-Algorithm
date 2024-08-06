public class abstraction {
    public static void main(String args[]){
        Car car = new Car("Altroz", "TATA", "Ailwal Azamgarh");
        car.car_agencay_addreess();
        car.car_details();
    }
}

/**
+ * This is an abstract class named CarBluePrint. 
+ * It has two abstract methods: car_agencay_addreess and car_details.
+ * 
+ * The car_agencay_addreess method is used to provide the address of the car agency.
+ * The car_details method is used to provide the details of the car.
+ * 
+ * This class is used as a blueprint for creating different types of cars.
+ * The car_agencay_addreess and car_details methods are left unimplemented and must be implemented by the concrete classes that extend this abstract class.
+ */
abstract class CarBluePrint{
 
    /**
+     * This is an abstract method that provides the address of the car agency.
+     */
    public abstract void car_agencay_addreess();
    
   /**
+     * This is an abstract method that provides the details of the car.
+     */
     public abstract void car_details();
}


/**
+ * This class extends the abstract class CarBluePrint.
+ * It provides the concrete implementation for the abstract methods 
+ * car_agencay_addreess and car_details.
+ */
 class Car extends CarBluePrint{
     String car_name;
     String company;
     String company_address;
 
    /**
+     * Constructor for the Car class.
+     * @param car_name The name of the car.
+     * @param company The company that manufactures the car.
+     * @param company_address The address of the company.
+     */
     Car(String car_name, String company, String company_address){
         this.car_name = car_name;
         this.company = company;
         this.company_address = company_address;
     }
 
    /**
+     * Implementation of the abstract method car_agencay_addreess.
+     * Prints the address of the car agency.
+     */
     public void car_agencay_addreess(){
         System.out.println("Car agency address is: " + this.company_address);
     }
 
    /**
+     * Implementation of the abstract method car_details.
+     * Prints the details of the car.
+     */
     public void car_details(){
         System.out.println("Car name is: " + this.car_name);
         System.out.println("Car company name is: " + this.company);
     }
 }



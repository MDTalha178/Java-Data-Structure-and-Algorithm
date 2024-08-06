public class ClassCreation{

     /**
+     * Main method to demonstrate the creation and usage of a Pen object.
+     *
+     * @param args command line arguments
+     */
     public static void main(String args[]){
        // Create a new Pen object
         Pen p1 = new Pen();

       // Set the color of the pen
         p1.setColor();
 
        // Get the color of the pen and print it to the console
         System.out.println(p1.getColor());
     }

}

/**
+ * Class Pen represents a simple pen object with a color and a tip. 
+ * It has methods to set the color and get the color of the pen.
+ */
 class Pen {
     String color;
     int tip;
 
    /**
+     * Sets the color of the pen.
+     */
    void setColor(){
         System.out.println("Adding color");
         this.color =  "Red";
    }
 
    /**
+     * Gets the color of the pen.
+     * @return the color of the pen
+     */
    String getColor(){
         System.out.println("Getting color..");
         return this.color;
    }
 }



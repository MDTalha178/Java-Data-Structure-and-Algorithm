import java.util.ArrayList;
import java.util.Scanner;



/**
+ * This class demonstrates the creation of a two dimensional ArrayList.
+ * The main method creates a two dimensional ArrayList, reads the number of rows and columns
+ * from the user input, and populates the list with the user input numbers.
+ * Finally, it prints the populated list.
+ *
+ * @author Unknown
+ */
 public class twoD_arraylist {
     public static void main(String args[]){
        // Create a two dimensional ArrayList
        ArrayList<ArrayList>mainList = new ArrayList<>();
 
        // Read the number of rows and columns from the user input
         Scanner sc = new Scanner(System.in);
         int row = sc.nextInt();
         int col = sc.nextInt();
 
        // Populate the list with the user input numbers
         for(int i =0; i<row; i++){
            ArrayList<Integer> list = new ArrayList<>();
             for(int j = 0; j<col; j++){
                 int num = sc.nextInt();
                 list.add(num);
             }
             mainList.add(list);
         }

        // Print the populated list
         System.out.println(mainList);
     }
}

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
 public class print_two_array_list {
    /**
+     * This method prints the two dimensional ArrayList.
+     *
+     * @param mainList - the two dimensional ArrayList to be printed
+     */
    public static void print_two_array_list(ArrayList<ArrayList> mainList) {
        // Iterate over each row in the mainList
        for (int i = 0; i < mainList.size(); i++) {
            // Get the current row's ArrayList
            ArrayList<Integer> current_list = mainList.get(i);

            // Iterate over each element in the current row's ArrayList
            for (int j = 0; j < current_list.size(); j++) {
                // Print the element
                System.out.print(current_list.get(j) + " ");
            }
         } 
}
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
        print_two_array_list(mainList);
     }
}

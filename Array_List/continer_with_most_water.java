import java.util.ArrayList;
import java.util.Scanner;
public class continer_with_most_water {

    /**
+     * This function solves the problem of finding the maximum water that can be
+     * contained in a container using two pointer approach.
+     *
+     * @param  list The list of heights of the bars
+     * @return      The maximum water that can be contained
+     */
        // Print the message to indicate the approach being used
    public static int solvinf_with_two_pointer_approach(ArrayList<Integer>list){
        System.out.println("Solving with Two Pointer Approach");

        // Initialize variables
        int max_water = 0;
        int start = 0;
        int end = list.size() - 1;
 
        // Two pointer approach
        while (start <= end) {
            // Calculate the height of the container
        while(start <= end){
             int height = Math.min(list.get(start), list.get(end));

            // Calculate the width of the container
            int width = end - start;

            // Calculate the current water that can be contained
            int cur = height * width;

            // Update the maximum water if the current water is greater
             max_water = Math.max(max_water, cur);
 
            // Move the pointers based on the smaller height of the bars
            if(list.get(start) < list.get(end)){
                start++;
            }
            else {
                end--;
            }
        }
    }
     // Return the maximum water that can be contained
     return max_water;
}
    public static int solving_with_BTF(ArrayList<Integer>arr){
        System.out.println("Solving with Brute Froce Approach");
        int max_water = 0;
        for(int i=0; i<arr.size(); i++){
            for(int j=i+1; j<arr.size(); j++){
                int height = Math.min(arr.get(i), arr.get(j));
                int width = j-i;
                int cur = height * width;
                max_water = Math.max(max_water, cur);
            }
        }
        return max_water;
    }
    public static void main(String args[]){
        ArrayList<Integer>list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int number_of_element = 4;
        for(int i =0; i<number_of_element; i++){
            int cur =  sc.nextInt();
            list.add(cur);
        }

        int max_water_from_btf = solving_with_BTF(list);
        int max_water_from_two_pointer = solvinf_with_two_pointer_approach(list);
        System.out.println(max_water_from_btf + " " + max_water_from_two_pointer);
    }
}

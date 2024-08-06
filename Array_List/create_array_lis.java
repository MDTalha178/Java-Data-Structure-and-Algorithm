import java.util.ArrayList;
import java.util.Collections;

/**
 * create_array_lis
**/
/**
* This class demonstrates the creation of an ArrayList of Integer and performing
* add operation on it. The main method creates an ArrayList, adds elements to it
* and then prints the first two elements of the list.
*
* @author Unknown
**/
public class create_array_lis {
    /**
     * The main method that creates an ArrayList of Integer and performs add
     * operation on it.
     *
     * @param args - command line arguments (unused)
    **/
    /** 
     * This is the main method that will create an ArrayList of Integer 
     * and perform add operation on it.
     * @param args - command line arguments (unused)
     **/
    public static void main(String args[]){
          // declaration for Array list
          ArrayList<Integer>list = new ArrayList<>();
  
         // Here we perform add operation on my list
         list.add(1); // adding 1 to list
         list.add(2); // adding 2 to list
         list.add(3); // adding 3 to list
         list.add(4); // adding 4 to list
  
         /**
+          * Now the list is: [1, 2, 3, 4]
+          * We can see that the list is of size 4 and its elements are
+          * [1, 2, 3, 4]
+          */
        int ele1 = list.get(0);
        int ele2 = list.get(1);
        System.out.println("First two elements of the list: " + ele1 + " ," + ele2);

        /** 
        * here we perform remove element from a list usinf remove method
        */
        list.remove(2);
        System.out.println(list);
        /**
+        * Now the list is: [1, 2, 4]
+          * We can see that the list is of size 4 and its elements are
+          * [1, 2, 3, 4]
+        */
        /**
         * now here we perform set operation to update a value in the list
         * using set method
         */
        list.set(1,10);
        System.out.println(list);
        /**
+          * Now the list is: [1, 2, 3, 4]
+          * We can see that the list is of size 4 and its elements are
+          * [1, 10, 4]
+        */
        /*
         * Now we will check to any value or number is present in our list or not
         * using contains method
         * its return a boolean value
         */
        boolean is_present = list.contains(10);
        System.out.println(is_present);

         /**
         * now here we perform add operation but here wa can add to any index
         * using add method
         */
        list.add(0, 12);
        System.out.println(list);

        /**
         * here we perform sorting on list using sort method
         */
        Collections.sort(list);
        System.out.println(list);

    }
}
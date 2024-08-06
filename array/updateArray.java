public class updateArray {

    // update arrays
    public static void updateArray(int array[]){
        for(int i=0; i<array.length; i++){
            array[i] = array[i] + i;
        }
    }

    // print array
    public static void printArray(int array[]){
        for(int i =0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int array[] = {76,45, 34};
        System.out.println("Your Array:");
        printArray(array);
        updateArray(array);

        System.out.println("Your Updated Arary:");
        printArray(array);
    }
}

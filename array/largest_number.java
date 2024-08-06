public class largest_number {

    public static int findLargestNumber(int arr[]){
        int largest_number = arr[0];
        if(arr.length == 1){
            return largest_number;
        }
        else{
            for(int i = 1; i < arr.length; i++){
                if(arr[i] > largest_number){
                    largest_number = arr[i];
                }
            }
        }
        return largest_number;
    }
    public static void main(String args[]){
        int array[] = {1,2,3,1,4,5,12, 90};

        System.out.println("We are finding largest number please wait....");
        int largest_number = findLargestNumber(array);
        System.out.println("Your largest number is " + largest_number);
    }
}

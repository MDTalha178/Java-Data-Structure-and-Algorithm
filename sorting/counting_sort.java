public class counting_sort {
    public static void counting_sort(int arr[], int largest_number){
        int freq_arr[] = new int[largest_number +1];

        // here we store freq
        for(int i =0; i<arr.length; i++){
            freq_arr[arr[i]]++;
        }

        // counting sort
        int j =0;
        for(int i =0; i< freq_arr.length; i++){
            while(freq_arr[i] > 0){
                arr[j] = i;
                j++;
                freq_arr[i]--;
            }
        }
    }
    public static int largest_number_in_array(int arr[]){
        int largest_number = Integer.MIN_VALUE;
        for(int i =0; i< arr.length; i++){
            largest_number = Math.max(arr[i], largest_number);
        }
        return largest_number;
    }

    public static void printArray(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]){
        int arr[] = {9,3,2,1,2,3};

        int largest_number = largest_number_in_array(arr);
        counting_sort(arr, largest_number);
        printArray(arr);
    }
}

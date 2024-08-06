public class trapped_water {

    public static int calculate_trapped_water(int arr[], int left_max[], int right_max[]){
        int trapped_water = 0;
        for(int i =0; i<arr.length; i++){
            int min_trapped_water = Math.min(left_max[i], right_max[i]);
            trapped_water += min_trapped_water - arr[i];
        }
        return trapped_water;
    }
    public static void main(String args[]){
        int arr[] = {0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        // here we will calculate left max number
        int left_max[] = new int[arr.length];
        left_max[0] = arr[0];
        for(int i =1; i< arr.length; i++){
           left_max[i] = Math.max(left_max[i-1], arr[i]);

        }

        // here we will calculate right max number
        int right_max[] = new int[arr.length];
        right_max[arr.length -1] = arr[arr.length-1];
        for(int i= arr.length-2; i>=0; i--){
            right_max[i] = Math.max(right_max[i+1], arr[i]);
        }
        int trapped_water = calculate_trapped_water(arr, left_max, right_max);
        System.out.println("Minimum Trapped water " + trapped_water);

    }
}

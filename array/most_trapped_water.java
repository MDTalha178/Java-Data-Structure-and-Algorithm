// Container With Most Water

// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49

public class most_trapped_water {
    public static int maximum_water_container(int arr[]){
        int max = 0;
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int area = 0;
            int lenght = Math.abs(left - right);
            int breadth  = Math.min(arr[left], arr[right]);
            area = lenght * breadth;
            max = Math.max(max, area);
            if(arr[left] <= arr[right]){
                left ++;
            }else{
                right--;
            }
        }
        return max;
    }
    public static void main(String args[]){
        int arr[] = {1,8,6,2,5,4,8,3,7};

        int max_water = maximum_water_container(arr);
        System.out.println(max_water);

    }
}

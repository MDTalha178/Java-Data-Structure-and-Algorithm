import java.util.Stack;
public class Maximum_Histogram {
    public static void get_right_smallest(int right_smallest[], int arr[]){
        Stack<Integer>stack = new Stack<>();
        for(int i =right_smallest.length-1; i>=0; i--){
            int curr = arr[i];

            while (!stack.empty() &&  arr[stack.peek()] >= curr) {
                stack.pop();
            }
            if(stack.empty()){
                right_smallest[i] = arr.length-1;
            }else{
                right_smallest[i] = stack.peek();
            }
            stack.push(i);
        }
    }
    public static void get_left_smallest(int left_smllest[], int arr[]){
        Stack<Integer>stack = new Stack<>();
        for(int i =0; i < left_smllest.length; i++){
            int curr = arr[i];

            while (!stack.empty() &&  arr[stack.peek()] >= curr) {
                stack.pop();
            }
            if(stack.empty()){
                left_smllest[i] = arr.length-1;
            }else{
                left_smllest[i] = stack.peek();
            }
            stack.push(i);
        }
    }
    public static int getMaximumHistogram(int arr[]){
        int max_histo = 0;
        int left_smllest[] = new int[arr.length];
        int right_smallest[] = new int[arr.length];
        
        get_left_smallest(left_smllest, arr);
        get_right_smallest(right_smallest, arr);


        for(int i =0; i<arr.length; i++){
            int width = right_smallest[i] - left_smllest[i] -1;
            int area = width * arr[i];
            max_histo = Math.max(max_histo, area);
        }
        return max_histo;




    }
    public static void main(String args[]){
        int arr[] = {2,1,5,6,2,3};

        int Maximum_Histogram = getMaximumHistogram(arr);
        System.out.println(Maximum_Histogram);
    }
}

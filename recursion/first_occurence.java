public class first_occurence {


    public static int first_occurence_index(int arr[], int find_ele, int i){
        if(i == arr.length -1){
            if(arr[i] == find_ele){
                return i;
            }
            else{
                return -1;
            }
        }
        if(arr[i] == find_ele){
            return i;
        }
        return first_occurence_index(arr, find_ele, i+1);
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,45};
        int idx = first_occurence_index(arr, 45, 0);
        System.out.println(idx);
    }
}

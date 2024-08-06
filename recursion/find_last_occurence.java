public class find_last_occurence {
    
    public static int find_last_occurence(int arr[], int find_ele, int i){
        if(i == arr.length){
           return -1;
        }
        int idx = find_last_occurence(arr, find_ele, i+1);
        if(idx == -1){
            if(arr[i] == find_ele){
                return i;
            }
            else{
                return -1;
            }
        }
        else{
            return idx;
        }

    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,1,3,2, 3};
        int idx = find_last_occurence(arr, 3, 0);
        System.out.println(idx);
    }
}

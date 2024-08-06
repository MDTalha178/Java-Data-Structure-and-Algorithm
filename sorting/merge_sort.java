public class merge_sort {
    public static void merge(int arr[], int start, int mid, int end){
        int temp[] = new int[end - start + 1];

        int i = start;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j<=end){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j<=end){
            temp[k++] = arr[j++];
        }
        for(int l = 0, m = start; l<temp.length; l++, m++){
            arr[m] = temp[l];
        }
    }
    public static void merge_sort(int arr[], int start, int end){
        if(start >= end){
            return;
        }
        int mid =(start + end) / 2;
        merge_sort(arr, start, mid);
        merge_sort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }
    public static void main(String args[]){
        int arr[] = {9,3,2,1,4,5};
        merge_sort(arr, 0, arr.length-1);

        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

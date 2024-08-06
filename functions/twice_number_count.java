public class twice_number_count {

    public static boolean is_number_twice(int arr[]){
        boolean is_twice = false;
        for(int i = 0; i<arr.length; i++){
            int temp_count  = 1;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] == arr[i]){
                    temp_count += 1;
                }
            }
            if(temp_count > 1){
                is_twice = true;
                break;
            }
        }
        return is_twice;
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,9};

        boolean is_number_twice = is_number_twice(arr);
        if(is_number_twice){
            System.out.println("Yes number is present twice");
        }
        else{
            System.out.println("No number is present twice");
        }
    }
}

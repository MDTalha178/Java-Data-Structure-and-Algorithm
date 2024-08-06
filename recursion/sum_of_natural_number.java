public class sum_of_natural_number {
    public static int sum_of_natural_number(int n){
        if(n == 1){
            return 1;
        }
        int small = sum_of_natural_number(n-1);
        return n + small;
    }
    public static void main(String args[]){
        int small  = sum_of_natural_number(4);
        System.out.println(small);
    }
}

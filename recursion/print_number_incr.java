public class print_number_incr{

    public static void print_number_dec(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print_number_dec(n-1);
    }
    public static void main(String[] args) {
        print_number_dec(10);
    }
}

public class tilling_problem {

    public static int tilling_problem_sol(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        // vertical 
        int ver = tilling_problem_sol(n-1);

        // horizontal
        int hor =  tilling_problem_sol(n-2);
        int total =  hor + ver;
        return total;
    }
    public static void main(String args[]){
        int n = 2;
        int toatl_ways = tilling_problem_sol(n);
        System.out.println(toatl_ways);
    }
}

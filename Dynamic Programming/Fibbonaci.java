public class Fibbonaci {

    public static int memoizationApproach(int n, int dp[]){

        // base condition
        if(n == 0 || n == 1){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = memoizationApproach(n-1, dp) + memoizationApproach(n-2, dp);
    }

    public static int tabulisationApproach(int n, int tb[]){

        tb[0] = 0;
        tb[1] = 1;
        for(int i =2; i<=n; i++){
            tb[i] = tb[i-1] + tb[i-2];
        }

        return tb[n];
    }

    public static void main(String args[]){
        int n = 6;

        // this approach will use memoization
        int dp[] = new int[n+1];
        int fib = memoizationApproach(n, dp);
        System.out.println("Using Memoization Approcah " +  fib);


        // this approach will use tabulisation
        int tb[] = new int[n+1];
        int fibTB = tabulisationApproach(n, tb);
        System.out.println("Using Tabulisation Approcah " +  fibTB);

    }
}
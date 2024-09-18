import java.util.Arrays;
public class ClimbingStairs {

    public static int climbingRcursiveApproach(int n){

        // base case 
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        return climbingRcursiveApproach(n -1) + climbingRcursiveApproach(n - 2);
    }

    public static int climbingMemoiztionApproach(int n, int dp[]){

        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = climbingMemoiztionApproach(n -1, dp) + climbingMemoiztionApproach(n-2, dp);
        return dp[n];
    }

    public static int climbingTabulationApproach(int n){

        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){

            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    public static void main(String args[]){

        int n = 5;

        // recursive approach
        int climbing1 = climbingRcursiveApproach(n);
        System.out.println("Rcursive Approach "+ climbing1);

        // memoization Approrach
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        int climbing2 =  climbingMemoiztionApproach(n, dp);
        System.out.println("Memoization Approach " + climbing2);


        // tabulation Approach
        int climbing3 = climbingTabulationApproach(n);
        System.out.println("Tabluation Approach " + climbing3);
    }
}

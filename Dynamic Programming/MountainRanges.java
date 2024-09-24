import java.util.Arrays;

public class MountainRanges {

    public static int getbstformWays(int n){

        int dp[] = new int[n+1];

        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        for(int i =2; i<dp.length; i++){
            for(int j=0; j<i; j++){
                int outSide = dp[j];
                int inside = dp[i-j-1];
                dp[i] += inside * outSide;
            }
        }
        return dp[n];
    }
    
    public static void main(String args[]){

        int n =5;

        int numberOfWays = getbstformWays(n);
        System.out.println(numberOfWays);
    }
}

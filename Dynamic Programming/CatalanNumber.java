import java.util.*;
public class CatalanNumber {

    public static int getCatalanNumberRcursive(int n){

        // base condition
        if(n == 0 || n == 1){
            return 1;
        }

        int ans = 0;
        for(int i =0; i<n; i++){
            ans+=getCatalanNumberRcursive(i) * getCatalanNumberRcursive(n-i-1);
        }
        return ans;
    }

    public static int getCatalanNumberMemo(int n, int dp[]){

        // base condtion
        if(n ==0 || n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int ans = 0;
        for(int i =0; i<n; i++){
            ans+=getCatalanNumberMemo(i, dp)  * getCatalanNumberMemo(n-i-1, dp);
        }
        return dp[n] = ans;
    }

    public static int getCatalanNumberTabulation(int n){

        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i =2; i<dp.length; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    
    public static void main(String args[]){

        int n = 3;

        // Recursive
        int catalanNumber =  getCatalanNumberRcursive(n);
        System.out.println(catalanNumber);

        // Memoization Approach
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        catalanNumber = getCatalanNumberMemo(n, dp);
        System.out.println(catalanNumber);

        // Tabulation Approach
        catalanNumber = getCatalanNumberTabulation(n);
        System.out.println(catalanNumber);
    }


}

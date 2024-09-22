import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubSeq {

    public static int Increasing(int arr[], int idx, int prev){

        if(idx == arr.length){
            return 0;
        }

        // include condition
        int ans1 = 0;
        if(arr[idx] > prev){
            ans1 = 1+ Increasing(arr, idx+1, arr[idx]);
        }
        // exclude condition
        int ans2 =Increasing(arr, idx+1, arr[idx]);
        return Math.max(ans1, ans2);
    }

    public static int IncreasingMemo(int arr[], int idx, int prev, int dp[]){

        if(idx == arr.length){
            return 0;
        }

        // check already cal cultated
        if(dp[idx] != -1){
            return dp[idx];
        }

        // include condition
        int ans1 =0;
        if(arr[idx] > prev){
            ans1  = 1 + IncreasingMemo(arr, idx+1, arr[idx], dp);
        }

        // exclude cond
        int ans2 = IncreasingMemo(arr, idx+1, arr[idx], dp);
        return dp[idx] = Math.max(ans1, ans2);
    }

    private static int LongestCommonSubseq(int arr[], int arr2[]){

        int n = arr.length;
        int m = arr2.length;

        int dp[][] = new int[n+1][m+1];
        
        // tabulation
        for(int i =1; i<n+1; i++){

            for(int j=1; j<m+1; j++){
                if(arr[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];

    }

    public static int IncreasingTabulation(int arr[]){

        HashSet<Integer>set = new HashSet<>();

        for(int i =0; i<arr.length; i++){
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];
        int i=0;
        for(int num: set){
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2);
        return LongestCommonSubseq(arr, arr2);
    }
    
    public static void main(String args[]){
        int arr[] = {50,3,10,7,40,80};

        // Rcursive Approach
        int ans =  Increasing(arr, 0, Integer.MIN_VALUE);
        System.out.println(ans);


        // Memoization Approach
        int dp[] = new int [arr.length +1];
        Arrays.fill(dp, -1);
        ans = IncreasingMemo(arr, 0, Integer.MIN_VALUE, dp);
        System.out.println(ans);

        // Tabulation Approach
        ans  = IncreasingTabulation(arr);
        System.out.println(ans);


    }
}

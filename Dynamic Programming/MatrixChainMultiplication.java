public class MatrixChainMultiplication {

    public static int getMCM(int arr[], int i, int j){

        if(i == j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int k = i; k<=j-1; k++){

            int cost1 = getMCM(arr, i, k);
            int cost2 = getMCM(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }
    public static int getMCMMemo(int arr[], int i, int j, int dp[][]){

        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = getMCMMemo(arr, i, k, dp);
            int cost2 = getMCMMemo(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }

    public static int getMCTabu(int arr[]){

        int n = arr.length;
        int dp[][] = new int[n][n];

        for(int i =0; i<n; i++){
            dp[i][i] =0;
        }

        for(int len =2; len<=n-1; len++){
            for(int i=1; i<=n-len; i++){
                int j = i+len -1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++){

                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j] , cost1 + cost2 + cost3);
                }
            }
        }
        return dp[1][n-1];
    }
    
    public static void main(String args[]){


        // rcursive Approach
        int arr[] = {1,2,3,4,3};
        int mcm = getMCM(arr, 1, arr.length-1);
        System.out.println(mcm);

        // Memoization Approach
        int dp[][] = new int[arr.length +1][arr.length +1];
        for(int i =0; i<dp.length; i++){
            for(int j=0;j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        mcm = getMCMMemo(arr, 1, arr.length-1, dp);
        System.out.println(mcm);

        mcm = getMCTabu(arr);
        System.out.println(mcm);
    }
}

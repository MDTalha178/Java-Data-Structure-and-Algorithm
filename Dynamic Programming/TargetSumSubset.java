public class TargetSumSubset {

    public static boolean checkTargetSumExists(int arr[], int targetSum){

        boolean dp[][] = new boolean[arr.length + 1][targetSum + 1];

        for(int i=0; i<dp.length; i++){
            dp[i][0] = true;
        }

        // Tabulation
        for(int i =1; i<dp.length; i++){
            for(int j =1; j<dp[i].length; j++){
                int val = arr[i-1];

                if(val <= j && dp[i-1][j-val] == true){
                    dp[i][j] = true;
                }else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        return dp[arr.length][targetSum];
    }
    
    public static void main(String args[]){

        int arr[] = {4,2,7,1,3};
        int targetSum = 10;

        boolean targetSumExists = checkTargetSumExists(arr, targetSum);
        System.out.println(targetSumExists);
    }
}

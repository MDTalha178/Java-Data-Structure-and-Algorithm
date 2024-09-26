public class MinimumPartion {

    public static int getMinimumPartion(int arr[]){
        int n = arr.length;

        int sum = 0;

        for(int i =0; i<arr.length; i++){
            sum+=arr[i];
        }
        int weight = sum/2;
        int dp[][] = new int[n+1][weight+1];


        for(int i=1; i<dp.length; i++){
            for(int j =1; j<dp[i].length; j++){
                int val = arr[i-1];
                if(arr[i-1] <= j){

                    int includeAns = val + dp[i-1][j-val];
                    int notInclude = dp[i-1][j];
                    dp[i][j] = Math.max(includeAns, notInclude);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][weight];
        int sum2 = sum - sum1;
        return Math.abs(sum1-sum2);
    }
    
    public static void main(String args[]){
        int arr[] = {1,6,11,5};

        int minmmumPart = getMinimumPartion(arr);
        System.out.println(minmmumPart);
    }
}

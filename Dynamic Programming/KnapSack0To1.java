public class KnapSack0To1 {

    public static int maxProfitRcursion(int value[], int wt[], int weight, int index){

        if(weight == 0 || index ==0 ){

            return 0;
        }

        if(wt[index-1] <= weight){

            // include
            int ans1 =  value[index-1] + maxProfitRcursion(value, wt, weight-wt[index-1], index-1);

            // exclude condtion
            int ans2 = maxProfitRcursion(value, wt, weight, index-1);
            return Math.max(ans1, ans2);
        }else{
            return maxProfitRcursion(value, wt, weight, index-1);
        }
    }

    public static int maxProfitMemoization(int value[], int wt[], int weight, int index, int dp[][]){

        if(weight == 0 || index ==0){
            return 0;
        }

        if(dp[index-1][weight] != -1){
            return dp[index-1][weight];
        }
        if(wt[index-1] <= weight){

            // inlcude condtion
            int  ans1 =  value[index-1] + maxProfitMemoization(value, wt, weight-wt[index-1], index-1, dp);

            // exclude condtion
            int ans2 = maxProfitMemoization(value, wt, weight, index-1, dp);
            dp[index-1][weight] = Math.max(ans1, ans2);
            return dp[index-1][weight];
        }else{
            dp[index-1][weight] = maxProfitMemoization(value, wt, weight, index-1, dp);
            return dp[index-1][weight];
        }
    }

    public static int maxProfitTabulationApproach(int value[], int wt[], int weight){

        int dp[][] = new int[value.length + 1][weight + 1];

        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }

        for(int j =0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        // tabulation
        for(int i =1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){

                int val = value[i-1];
                int we = wt[i-1];

                if(we <= j){

                    // include condition
                    int ans1 = val + dp[i-1][j-we];

                    // exclude condition
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i=0; i<dp.length; i++){
            for(int j =0; j<dp[i].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[value.length][weight];
    }
    
    public static void main(String args[]){

        int value[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int index = value.length;
        int weight = 7;

        // Recursion Approach
        int maxProfitRcursion = maxProfitRcursion(value, wt, weight, index);
        System.out.println("Recursive Approach "+  maxProfitRcursion);


        // Memoization Approach
        int dp[][] = new int[index+1][weight+1];
        for(int i =0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        int maxProfitMemoization = maxProfitMemoization(value, wt, weight, index, dp);
        System.out.println("Memoization Approach " + maxProfitMemoization);


        // Tabulation Approach
        int maxProfitTabulation = maxProfitTabulationApproach(value, wt, weight);
        System.out.println("Tabulation Approach "+  maxProfitTabulation);
    }
}

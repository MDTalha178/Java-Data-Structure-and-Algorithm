public class CoinChange {

    public static int getCoinChnageWays(int coins[], int sum){

        // here we will intialize
        int dp[][] = new int[coins.length + 1][sum +1];

        // here we will intialize row as 1
        for(int i =0; i<coins.length; i++){
            dp[i][0] = 1;
        }

        // Tabulation
        for(int i =1; i< dp.length; i++){

            for(int j=1; j<dp[i].length; j++){

                int val = coins[i-1];

                // check coin is less than for change coind that is j
                if(val <=j){ // valid condtion

                    // include condtion
                    int ans1 = dp[i][j-val];

                    // exclude condition
                    int ans2 = dp[i-1][j];

                    dp[i][j] = ans1 + ans2;
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        for(int i =0; i< dp.length; i++){
            for(int j =0; j<dp[i].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[coins.length][sum];
    }
    
    public static void main(String args[]){

        int coins[] = {2,5,3,6};
        int sum = 10;

        int coinsChangeWays = getCoinChnageWays(coins, sum);
        System.out.println(coinsChangeWays);
    }
}

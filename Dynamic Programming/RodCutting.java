public class RodCutting {

    public static int getMaxRodLength(int rodPieces[], int rodLength, int rodPrice[]){
         // here we will intialize
        int dp[][] = new int[rodPieces.length + 1][rodLength +1];

        // here we will intialize row as 1
        for(int i =0; i<rodPieces.length; i++){
            dp[i][0] = 1;
        }

        // Tbulation
        for(int i=1; i<dp.length; i++){

            for(int j=1; j<dp[i].length; j++){

                int rod_price = rodPrice[i-1];
                int rod_len = rodPieces[i-1];

                if(rod_len <= j){

                    // include condtion
                    int ans =  rod_price + dp[i-1][j-rod_len];
                    int ans2 = dp[i-1][j];

                    dp[i][j] = Math.max(ans, ans2);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[rodPieces.length][rodLength];
 
    }
    
    public static void main(String args[]){

        int rodPieces[] = {1,2,3,4,5,6,7,8};
        int rodPrice[] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;

        int maxRodLenght = getMaxRodLength(rodPieces, rodLength, rodPrice);
        System.out.println(maxRodLenght);

    }
}

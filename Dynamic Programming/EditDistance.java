public class EditDistance {

    public static int getNumberOfOperation(String s1, String s2, int n, int m){

        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }

        // check if both character is same
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return getNumberOfOperation(s1, s2, n-1, m-1);
        }

        // check for add operation
        int addOperation = getNumberOfOperation(s1, s2, n, m-1);
        int deleteOpration = getNumberOfOperation(s1, s2, n-1, m);
        int replaceOperation = getNumberOfOperation(s1, s2, n-1, n-1);
        return Math.min(deleteOpration, Math.min(addOperation, replaceOperation)) + 1;

    }

    public static int getNumberOfOperationMemo(String s1, String s2, int n, int m, int dp[][]){

        if(n == 0){
            return m;
        }

        if(m == 0){
            return n;
        }

        // check we have already calculated
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        // check if character is same
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = getNumberOfOperation(s1, s2, n-1, m-1);
        }

        // check for add operation
        int addOperation = getNumberOfOperation(s1, s2, n, m-1);
        // check for add delete
        int deleteOpration = getNumberOfOperation(s1, s2, n-1, m);
        // check for add replcae
        int replaceOperation = getNumberOfOperation(s1, s2, n-1, n-1);
        return dp[n][m] = Math.min(deleteOpration, Math.min(addOperation, replaceOperation)) + 1;
    }

    public static int getNumberOfOperationTabu(String s1, String s2, int n, int m){

        int dp[][] = new int[n+1][m+1];

        for(int i =0; i<dp.length; i++){
            for(int j =0; j<dp[i].length; j++){

                if(i == 0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }

            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j =1; j<dp[i].length; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{

                    int add = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = Math.min(add, Math.min(delete, replace)) + 1;
                }
            }
        }
        return dp[n][m];

    }
    
    public static void main(String args[]){

        String s1 = "intention";
        String s2 = "execution";

        // Rcursive Approach
        int ans = getNumberOfOperation(s1, s2, s1.length(), s2.length());
        System.out.println(ans);

        // Memoization Approach
        int dp[][] = new int[ s1.length()+1][s2.length()+1];
        for(int i =0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }   
        }
        ans = getNumberOfOperationMemo(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(ans);

        // Tabulation Approach
        ans = getNumberOfOperationTabu(s1, s2, s1.length(), s2.length());
        System.out.println(ans);
    }
}

public class StringConvresion {

    public static int getlogestSubSeq(String s1, String s2){

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i =1; i<dp.length; i++){
            for(int j =1; j<dp[i].length; j++){
                
                // check if character is same
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int getNumberOfOperation(String s1, String s2){

        int lcs = getlogestSubSeq(s1, s2);
        int ans = (s1.length() - lcs) + (s2.length() - lcs);
        return ans;

    }
    
    public static void main(String args[]){

        String s1 = "pear";
        String s2 = "sea";

        // Tabulation
        int NumberOfOperation = getNumberOfOperation(s1, s2);
        System.out.println(NumberOfOperation);
    }
}

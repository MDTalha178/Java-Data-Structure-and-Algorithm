public class LongestCommonSubseq {

    public static int getlogestSubSeq(String s1, String s2, int m, int n){

        // Base case
        if(m == 0 || n==0){
            return 0;
        }

        // Rcursive call if both string is same
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return 1 + getlogestSubSeq(s1, s2, m-1, n-1);
        }else{

            int ans1 = getlogestSubSeq(s1, s2, m-1, n);
            int ans2 = getlogestSubSeq(s1, s2, m, n-1);

            return Math.max(ans1, ans2);
        }
    }

    public static int getlogestSubSeqMemo(String s1, String s2, int m, int n, int dp[][]){

        // Base case
        if(m == 0 || n == 0){
            return 0;
        }

        // Before calling rcursion we need to we already have solution for this
        if(dp[m][n] !=-1){
            return dp[m][n];
        }
        else if(s1.charAt(m-1) == s2.charAt(n-1)){
            return dp[m][n] = 1 + getlogestSubSeq(s1, s2, m-1, n-1);
        }else{
            return dp[m][n] = Math.max(getlogestSubSeq(s1, s2, m-1, n), getlogestSubSeq(s1, s2, m, n-1));
        }
    }

    public static int getlogestSubSeqTabulation(String s1, String s2, int m, int n){

        int dp[][] = new int[m+1][n+1];

        for(int i=1; i<dp.length; i++){

            for(int j=1; j<dp[i].length; j++){

                // check character is Match
                if(s1.charAt(i-1) == s2.charAt(j-1)){

                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{

                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];

                    dp[i][j] = Math.max(ans1, ans2);

                }
            }
        }
        return dp[m][n];
    }
    
    public static void main(String args[]){

        String s1 = "abcde";
        String s2 = "ace";

        // Rcursion Approach
        int logestSubSeq = getlogestSubSeq(s1, s2, s1.length(), s2.length());
        System.out.println("Rcursive Approach " + logestSubSeq);


        // Use Memoization Approach
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        logestSubSeq = getlogestSubSeqMemo(s1, s2, s1.length(), s2.length(), dp);
        System.out.println("Memoization Approach " + logestSubSeq);

        // Use Tabulation Approach
        logestSubSeq = getlogestSubSeqTabulation(s1, s2, s1.length(), s2.length());
        System.out.println("Tabulation Approach " + logestSubSeq);
    }
}

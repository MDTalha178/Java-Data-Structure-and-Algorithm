public class LongestCommonSubString {

    private static int maxns = -1;

    public static int  getlogestSubString(String s1, String s2, int n, int m, int ans){

        // base case
        if( m == 0 || n==0 ){
            return ans;
        }

        // fisrt check is substring is same
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            ans = getlogestSubString(s1, s2, n-1, m-1, ans+1);
        }
        int ans1 = getlogestSubString(s1, s2, n-1, m, 0);
        int ans2 = getlogestSubString(s1, s2, n, m-1, 0);
        return Math.max(ans1, Math.max(ans, ans2));

        
    }

    public static int getlogestSubStringMemo(String s1, String s2, int n, int m, int ans, int dp[][]){
        if(m == 0 || n ==0){
            return ans;
        }

        if(dp[n][m] !=-1){
            return dp[n][m];
        }
        else if(s1.charAt(n-1) == s2.charAt(m-1)){
            dp[n][m] = ans = getlogestSubString(s1, s2, n-1, m-1, ans+1);
        }
        int ans1 = getlogestSubStringMemo(s1, s2, n-1, m, 0, dp);
        int ans2 = getlogestSubStringMemo(s1, s2, n, m-1, 0, dp);
        return dp[n][m] = Math.max(ans1, Math.max(ans, ans2));
    }

    public static int getlogestSubStringTabulation(String s1, String s2, int n, int m){

        int dp[][] = new int[s1.length() +1][s2.length() +1];
        int maxAns = -1;
        for(int i =1; i<dp.length; i++){
            for(int j =1; j<dp[i].length; j++){

                // check if character are same
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;                }
                maxAns = Math.max(maxAns, dp[i][j]);
            }
        }
        return maxAns;
    }

    
    
    public static void main(String args[]){

        String s1 = "ABCSDE";
        String s2 = "ABGCE";

        // Recursive Approach
        int logestCoomon = getlogestSubString(s1, s2, s1.length(), s2.length(), 0);
        System.out.println(logestCoomon);

        // Memoization Approach
        int dp[][] = new int[s1.length() +1][s2.length() +1];

        for(int i=0; i<dp.length; i++){
            for(int j =0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        logestCoomon =  getlogestSubStringMemo(s1, s2, s1.length(), s2.length(), 0, dp);
        System.out.println(logestCoomon);

        // Tabulation Approach
        logestCoomon =  getlogestSubStringTabulation(s1, s2, s1.length(), s2.length());
        System.out.println(logestCoomon);

    }
}

public class WildCardMatching {

    public static boolean getIsMatch(String s1, String pattern){

        boolean dp[][] = new boolean[s1.length() +1][pattern.length() +1];

        dp[0][0] = true;

        for(int i =1; i<dp.length; i++){
            dp[i][0] = false;
        }

        for(int j =1; j<dp[0].length; j++){
            if(pattern.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1; i<dp.length; i++){
            for(int j =1; j<dp[i].length; j++){

                // fisrt condition of both character is same
                if(s1.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][pattern.length()];
    }
    
    public static void main(String args[]){
        String s1 = "baaabab";
        String pattern = "*****ba*****ab";

        boolean isMatch = getIsMatch(s1, pattern);
        System.out.println(isMatch);

    }
}

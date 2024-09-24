public class CountingTrees {
    public static int getbstformWays(int n){

        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<dp.length; i++){
            for(int j=0; j<i; j++){
                int left = i;
                int right = j;
                dp[i] += dp[right] * dp[left-right-1];
            }
        }
        return dp[n];
    }
    
    public static void main(String args[]){
        int n =3;

        int bstformWays = getbstformWays(n);
        System.out.println(bstformWays);
    }
}

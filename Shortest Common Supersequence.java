class Solution
{
    //Idea: Result will be (m+n-lcs) - this can be proved mathematically
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int n,int )
    {
        //Your code here
        //need a initialized dp array
            int[][] dp= new int[n+1][m+1];
            for (int i = 0; i < n+1; i++)
                dp[i][0] = 0;
 
            for (int i = 1; i < m+1; i++)
                dp[0][i] = 0;
               
            //fill dp array in bottom-up fashion
            for(int i=1; i< n+1; i++){
                for(int j=1; j< m+1; j++){
                    if(X.charAt(i-1) == Y.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
            
            return m+n-dp[n][m];
    }
}

class Solution
{
    //idea: LCS is common letters in order e.g. "ea" is LCS for (heap, pea)
    // # of insertions = b - LCS
    // # of deletions = a - LCS
    
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n= str1.length();
	    int m= str2.length();
	    
	    int[][] dp= new int[n+1][m+1];
            for (int i = 0; i < n+1; i++)
                dp[i][0] = 0;
 
            for (int i = 1; i < m+1; i++)
                dp[0][i] = 0;
               
            //fill dp array in bottom-up fashion
            for(int i=1; i< n+1; i++){
                for(int j=1; j< m+1; j++){
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
            
            return (n+m - 2* dp[n][m]);
	} 
}

class Solution{

    int longestCommonSubstr(String S1, String S2, int n, int m){
          int dp[][] = new int[n + 1][m + 1];
       
        // To store length of the longest
        // common substring
        int result = 0;
        char[] X = S1.toCharArray();
        char[] Y = S2.toCharArray();

        // Following steps build
        // LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                {
                    dp[i][j]
                        = dp[i - 1][j - 1] + 1;
                    result = Integer.max(result,
                                         dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }
        return result;
    }
}
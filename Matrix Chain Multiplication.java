class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        
        int[][] dp = new int[N][N];
        
        //initlialize dp array with -1
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                dp[i][j] = -1;
            }
        }
        
        return solve(arr, 1, N-1, dp);
        
    }
    
    static int solve(int arr[], int i, int j, int[][] dp){
        //base condition
        if(i >= j){
            dp[i][j] = 0;
            return dp[i][j];
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        //choice diagram
        dp[i][j] = Integer.MAX_VALUE;
        for(int k=i; k< j; k++){
            dp[i][j]= Math.min(dp[i][j], 
                        solve(arr, i, k, dp) +
                        solve(arr, k+1, j, dp) +
                        (arr[i-1] * arr[k] * arr[j]));
                       
        }  
        return dp[i][j];
        }
    }

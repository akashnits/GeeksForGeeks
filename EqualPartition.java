//Question link: https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        // code here
        for(int ele: arr){
            //sum it all
            sum = sum + ele;
        }
        
        if(sum % 2 == 0){
            //need a initialized dp array
            boolean[][] dp= new boolean[N+1][sum+1];
            for (int i = 0; i < N+1; i++)
                dp[i][0] = true;
 
            // If sum is not 0
            // then answer is false
            for (int i = 1; i < sum+1; i++)
                dp[0][i] = false;
                
            return subsetSum(arr, N, sum/2, dp) ? 1 : 0;
        }else{
            //we can't find equal partition as sum of array is odd
            return 0;
        }
    }
    
    public static boolean subsetSum(int arr[], int n, int sum, boolean[][] dp){
        for(int i=1; i< n+1; i++){
                for(int j=1; j< sum+1; j++){
                    
                    if(arr[i-1] <= j){
                        //we can pick or reject
                        dp[i][j] = (dp[i-1][j-arr[i-1]] || dp[i-1][j]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
        }
        return dp[n][sum];
    }
}
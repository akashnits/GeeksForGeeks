//Question link: https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
import java.io.*;

class GFG {
    //dp matrix will store the count
	public static void main (String[] args) {
		int sum = 10;
		int[] arr = {2,3,5,7,5,6,8,10};
        int N = arr.length;
            //need a initialized dp array
            int[][] dp= new int[N+1][sum+1];
            for (int i = 0; i < N+1; i++)
                dp[i][0] = 1;
 
            // If sum is not 0
            // then answer is 0
            for (int i = 1; i < sum+1; i++)
                dp[0][i] = 0;
                
        System.out.println(countSubsetSum(arr, N, sum, dp));
    }
    
    public static int countSubsetSum(int arr[], int n, int sum, int[][] dp){
        for(int i=1; i< n+1; i++){
                for(int j=1; j< sum+1; j++){
                    
                    if(arr[i-1] <= j){
                        //we can include or exclude
                        dp[i][j] = (dp[i-1][j-arr[i-1]] + dp[i-1][j]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
        }
        return dp[n][sum];
	}
}
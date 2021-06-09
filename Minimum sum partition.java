//Question link: https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
class Solution
{
    private static boolean[][] dp;
    private static List<Integer> sumList= new ArrayList<Integer>();
    
public static int minDiffernce(int arr[], int n) 
    { 
        // Your code goes here
        int sum = 0;
        // code here
        for(int ele: arr){
            //sum it all
            sum = sum + ele;
        }
        //need a initialized dp array
        dp= new boolean[n+1][sum+1];
        for (int i = 0; i < n+1; i++)
            dp[i][0] = true;
 
        for (int i = 1; i < sum+1; i++)
            dp[0][i] = false;
            
        subsetSum(arr, n, sum);

        return minDiff(sum, n);
    }
    public static void subsetSum(int arr[], int n, int sum){
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
    }
    
    //first element from mid in last row is the ans if dp[i][j]= true
    public static int minDiff(int sum, int n){
        int diff= Integer.MAX_VALUE;
        for (int j=sum/2; j>=0; j--){
            // Find the
            if (dp[n][j] == true){
                diff = sum-2*j;
                break;
            }   
        }
    return diff;
    }
};
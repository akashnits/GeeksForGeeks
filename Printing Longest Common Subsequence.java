/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    //dp matrix will store the lcs values
	public static void main (String[] args) {
	    
	        String text1= "abcde";
	        String text2= "acdke";
	        char[] X= text1.toCharArray();
	        char[] Y= text2.toCharArray();
	        int n= text1.length();
	        int m= text2.length();
            //need a initialized dp array
            int[][] dp= new int[n+1][m+1];
            for (int i = 0; i < n+1; i++)
                dp[i][0] = 0;
 
            for (int i = 1; i < m+1; i++)
                dp[0][i] = 0;
                
            StringBuilder result= new StringBuilder();    
            //fill dp array in bottom-up fashion
            for(int i=1; i< n+1; i++){
                for(int j=1; j< m+1; j++){
                    if(X[i-1] == Y[j-1]){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
            //contruct the path from the end to find lcs
            int i = n;
            int j= m;
            while( i > 0 && j > 0){
                if(X[i-1] == Y[j-1]){
                    //move diagonally up
                    result.append(X[i-1]);
                    --i;
                    --j;
                }else{
                    if(dp[i-1][j] > dp[i][j-1]){
                        --i;
                    }else{
                        --j;
                    }
                }
            }
            System.out.print(result.reverse().toString());
    }
    
}

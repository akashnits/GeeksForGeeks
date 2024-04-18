//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    
    int[][] dirs = {{1,-2}, {-1,-2}, {-1,2}, {1,2}, {2,-1}, {2,1}, {-2,-1}, {-2,1}};
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        KnightPos[0]--;
        KnightPos[1]--;
        
        TargetPos[0]--;
        TargetPos[1]--;
        
        return minSteps(KnightPos, TargetPos, N, new boolean[N][N]);
    }
    
    int minSteps(int[] knightPos, int[] targetPos, int n, boolean[][] visited){
        Queue<int[]> queue = new LinkedList();
        
        queue.offer(knightPos);
        
        int steps = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            for(int i=0; i < size; i++){
                int[] polled = queue.poll();
            
                // check if it matches the target
                if(polled[0] == targetPos[0] && polled[1] == targetPos[1]){
                    return steps;
                }
            
                //we move in all possible dirs and add to queue
                for(int[] dir: dirs){
                    // check if valid cell
                    int newRow = polled[0] + dir[0];
                    int newCol = polled[1] + dir[1];
                    
                    if(newRow < 0 || newRow >= visited.length || newCol < 0 || newCol >= visited[0].length){
                        // out of bounds
                        continue;
                    }
                    
                    // check if already visited, don't again again to queue
                    if(visited[newRow][newCol]){
                        continue;
                    }
                    
                    // add to queue now
                    int[] newCoords = new int[]{newRow, newCol};
                    queue.offer(newCoords);
                    
                    // mark visited
                    visited[newRow][newCol] = true;
                }
            }
            steps++;
        }
        
        return steps;
    }
}

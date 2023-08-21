//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    // using prims algo., create adjcency matrix from given edges
	    int[][] adjMat = new int[V][V];
	    
	    // loop over edges, fill adjMatrix
	    for(int[] edge: edges){
	        int u= edge[0];
	        int v = edge[1];
	        int wt = edge[2];
	        
	        adjMat[u][v] = wt;
	        adjMat[v][u] = wt;
	    }
	    return primMST(adjMat, V, E);
	}
	
	static int primMST(int[][] graph, int V, int E){
	    int sum =0;
	    // create a parent array
	    int[] parent = new int[V];
	    parent[0] = -1;
	    
	    // create dist array
	    int[] dist = new int[V];
	    // all vertices at INT_MAX except for src
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    dist[0] = 0;
	    
	    // create MST set to keep track of visited vertices
	    boolean[] mstSet = new boolean[V];
	    
	    for(int i=0; i < V-1; i++){ // loop over edges, for V vertices, MST has V-1 edges
	    
	        int u = selectMinVertex(dist, mstSet, V);
	        mstSet[u] = true; // mark visited
	    
	        for(int v=0; v < V; v++){ // loop over all vertices, finding neighboring vertices with the conditions satisfying:
	            // case 1: graph[u][v] != 0
	            // case 2: mstSet[v] != true
	            // case 3: graph[u][v] < dist[v]
	        
	            if(graph[u][v] != 0 && !mstSet[v] && graph[u][v] < dist[v]){
	                dist[v] = graph[u][v];
	                parent[v] = u;
	            }
	        }
	    }
	    
	    for(int distance: dist){
	        sum += distance;
	    }
	    return sum;
	}
	
	static int selectMinVertex(int[] dist, boolean[] mstSet, int V){
	    int min = Integer.MAX_VALUE, candidate = -1;
	    for(int u=0; u < V; u++){
	        if(mstSet[u]) continue;
	        if(dist[u] < min){
	            min = dist[u];
	            candidate = u;
	        }
	    }
	    return candidate;
	}
}

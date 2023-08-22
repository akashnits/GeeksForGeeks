


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    int sum =0;
	    int n = edges.length;
	    
	    // initialize DSU
	    int[] parent = new int[V];
	    for(int i=0 ; i< V; i++){
	        parent[i] = i;
	    }
	    
	    DSU dsu = new DSU(parent);
	    
	    // create min heap of graph nodes
	    PriorityQueue<GraphNode> graphNodesMinHeap = new PriorityQueue<>((a,b)->a.wt-b.wt);
	    for(int[] edge: edges){
	        graphNodesMinHeap.offer(new GraphNode(edge[0], edge[1], edge[2]));
	    }
	    
	    // we need to pick nodes with min wt and continue till we have V-1 edges
	    int count =0;
	    while( count < V-1 ){
	        // we keep making union
	        
	        GraphNode gNode = graphNodesMinHeap.poll();
	        
	        if(dsu.find(gNode.u) != dsu.find(gNode.v)){
	            // different parent, unite them
	            dsu.union(gNode.u, gNode.v);
	            sum += gNode.wt;
	            count++;
	        }
	        
	    }
	    
	    return sum;
	    
	}
	
	
	
	 static class DSU {
	    int[] parent;
	    
	    DSU(int[] parent){
	        this.parent= parent;
	    }
	    
	    int find(int i){
	        if( i == parent[i]){
	            return i;
	        }
	        
	        return find(parent[i]);
	    }
	    
	     void union(int x, int y){
	        int parent_x = find(x);
	        int parent_y = find(y);
	        
	        if(parent_x != parent_y){
	            // we need to make a union
	            parent[parent_x] = parent_y;
	        }
	    }
	}
	
	static class GraphNode{
	    int u;
	    int v;
	    int wt;
	    
	    GraphNode(int u, int v, int wt){
	        this.u = u;
	        this.v = v;
	        this.wt = wt;
	    }
	}
}

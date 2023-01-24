import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


class Graph {
	private int V;
	private LinkedList<Integer> adjLists[];
	private ArrayList<String> DFSList = new ArrayList<String>();;
	private ArrayList<String> BFSList = new ArrayList<String>();
	private boolean visited[];
  
	// Create graph
	public Graph(int vertices) {
		// number of index in linkedlist
		adjLists = new LinkedList[vertices];
		//total nodes
		visited = new boolean[vertices];
		V = vertices;
		// creates indexes in linkedList
		for (int i = 0; i < vertices; i++)
			adjLists[i] = new LinkedList<Integer>();
	}

	// Add edges
	void addEdge(int src, int dest) {
	  adjLists[src].add(dest);
	}
  
	// DFS algorithm
    void DFSUtil(int v, int endV, boolean visited[], LinkedList<Integer>[] adjLists2)
    {
        // current node is marked as visited 
        visited[v] = true;
		//add to DFSList
		this.DFSList.add(v + " ");

		// counter is the index
		int counter = 1;
        Iterator<Integer> i = adjLists2[v].listIterator();

        while (i.hasNext()) {
            int n = i.next();
			// removes numbers past endV
			if(n == endV){
				for (int j = counter ; j < adjLists2.length; j++){
					adjLists2[j].removeAll(adjLists2[j]);
				}
				//System.out.print(n);
				DFSList.add(n + " ");
				break;
			}
			/*
            if (visited[n]){
				for (int j = counter; j < adjLists2.length; j++){
					if(adjLists2[j].size() != 0 && adjLists2[j].get(0) == n && j+1 < adjLists2.length){
						adjLists2[j].removeAll(adjLists2[j]);
					}
				}
			}
			*/
			if (!visited[n]){
                DFSUtil(n, endV, visited, adjLists2);
			}
			counter++;
        }
		return;
    }
 
    // Depth First Search traversal.
    void DFS(int v, int endV)
    {

        // Mark all the vertices as not visited(false)
        boolean visited[] = new boolean[V];
       
		
		LinkedList<Integer> adjLists2[] = new LinkedList[V];
		for (int z = 0; z < V; z++){
			adjLists2[z] = new LinkedList<Integer>();
		}
		for(int k = 0; k < adjLists.length; k++){
			adjLists2[k].addAll(adjLists[k]);
			
		}
		 // Call the recursive DFSUtil

        DFSUtil(v, endV ,visited , adjLists2);

		DFSList.add(System.lineSeparator());
	
    }

	//Breadth First Search Traversal
	void BFS(int s, int end) {

		boolean visited[] = new boolean[V];
		LinkedList<Integer> adjLists2[] = new LinkedList[V];
		for (int z = 0; z < V; z++){
			adjLists2[z] = new LinkedList<Integer>();
		}
		for(int k = 0; k < adjLists.length; k++){
			adjLists2[k].addAll(adjLists[k]);
			
		}
		LinkedList<Integer> queue = new LinkedList();
	
		visited[s] = true;
		queue.add(s);
		int counter = 0;
		
		while (queue.size() != 0) {
		  s = queue.poll();
		  //System.out.print(s + " ");
		  BFSList.add(s + " ");
	
		  Iterator<Integer> i = adjLists2[s].listIterator();
		  while (i.hasNext()){
			
			int n = i.next();
			counter++;
			if(n == end){
				for (int j = counter - 1 ; j < adjLists2.length; j++){
					adjLists2[j].removeAll(adjLists2[j]);
				}
				//System.out.print(n);
				BFSList.add(n + " ");
				break;
			}
			if (!visited[n]) {
			  visited[n] = true;
			  queue.add(n);
			}
		  }

		}
		this.BFSList.add(System.lineSeparator());
	  }

	// getters
    public ArrayList<String> getDFS() {
        return this.DFSList;
    }


	public ArrayList<String> getBFS() {
		return this.BFSList;
	}
	
}
  
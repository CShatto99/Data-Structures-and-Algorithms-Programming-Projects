// This project prints out the connectivity table for a directed graph.
// TEST CLASS
public class TestClass13_3 {
	
	// STACK CLASS
	public static class Stack {
		private final int size = 20;
		private int arr[];
		private int top;
		
		public Stack() {
			arr = new int[size];
			top = -1;
		}
		
		public void push(int val) {
			arr[++top] = val;
		}
		
		public int pop() {
			return arr[top--];
		}
		
		public int peek() {
			return arr[top];
		}
		
		public boolean isEmpty() {
			return (top == -1);
		}
	}
	// END STACK CLASS
	
	// VERTEX CLASS
	public static class Vertex {
		public char label;
		public boolean wasVisited;
		
		public Vertex(char l) {
			label = l;
			wasVisited = false;
		}
	}
	// END VERTEX CLASS
	
	// GRAPH CLASS
	public static class Graph {
		private final int MAX_VERTICES = 20;
		private int nVerts;
		private int adjMat[][];
		private Vertex vertexList[];
		private Stack theStack;
		
		public Graph() {
			nVerts = 0;
			
			adjMat = new int[MAX_VERTICES][MAX_VERTICES];
			for(int i = 0; i < MAX_VERTICES; i++)
				for(int j = 0; j < MAX_VERTICES; j++)
					adjMat[i][j] = 0;
			
			vertexList = new Vertex[MAX_VERTICES];
			theStack = new Stack();
		}
		
		public void addVertex(char l) {
			vertexList[nVerts++] = new Vertex(l);
		}
		
		public void addEdge(int start, int end) {
			adjMat[start][end] = 1;
		}
		
		public void displayVertex(int v) {
			System.out.print(vertexList[v].label);
		}
		
		public int getUnvisitedVert(int v) {
			for(int i = 0; i < nVerts; i++)
				if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false)
					return i;
			return -1;
		}
		
		public void dfs() {
			int startingVertex = 0;
			while(startingVertex < nVerts) {
				vertexList[startingVertex].wasVisited = true;
				displayVertex(startingVertex);
				theStack.push(startingVertex);
				
				while(!theStack.isEmpty()) {
					int v = getUnvisitedVert(theStack.peek());
					if(v == -1)
						theStack.pop();
					else {
						vertexList[v].wasVisited = true;
						displayVertex(v);
						theStack.push(v);
					}
				}
				System.out.println();
				startingVertex++;
				
				for(int i = 0; i < nVerts; i++)
					vertexList[i].wasVisited = false;
			}
		}
	}
	// END GRAPH CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		
		theGraph.addVertex('A');    // 0
		theGraph.addVertex('B');    // 1 
		theGraph.addVertex('C');    // 2 
		theGraph.addVertex('D');    // 3 
		theGraph.addVertex('E');    // 4
		
		theGraph.addEdge(1, 0);     // BA
		theGraph.addEdge(1, 4);     // BE 
		theGraph.addEdge(0, 2);     // AC 
		theGraph.addEdge(4, 2);     // EC
		theGraph.addEdge(3, 4);		// DE

		theGraph.dfs();
	}
	// TEST METHOD
}
// TEST CLASS
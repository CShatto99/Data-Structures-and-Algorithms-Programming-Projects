// This project implements a method to find a minimum spanning tree in a graph using breadth-first search.
// TEST CLASS
public class TestClass13_1 {
	
	// QUEUE CLASS
	public static class Queue {
		public final int size = 20;
		public int rear, front;
		public int qArray[];
		
		public Queue() {
			front = 0;
			rear = -1;
			qArray = new int[size];
		}
		
		public void insert(int value) {
			if(rear == size-1)
				rear = -1;
			qArray[++rear] = value;
		}
		
		public int remove() {
			int temp = qArray[front++];
			if(front == size)
				front = 0;
			return temp;
		}
		
		public boolean isEmpty() {
			return(rear+1 == front || front+size+1 == rear);
		}
	}
	// END QUEUE CLASS
	
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
		private final int MAX_VERTS = 20;
		private int nVerts;
		private Vertex vertexList[];
		private Queue theQueue;
		private int adjMat[][];
		
		public Graph() {
			nVerts = 0;
			vertexList = new Vertex[MAX_VERTS];
			theQueue = new Queue();
			adjMat = new int[MAX_VERTS][MAX_VERTS];
			
			// Initialize matrix values to 0
			for(int i = 0; i < MAX_VERTS; i++)
				for(int j = 0; j < MAX_VERTS; j++)
					adjMat[i][j] = 0;
		}
		
		public void addVertex(char lab) {
			vertexList[nVerts++] = new Vertex(lab);
		}
		
		public void addEdge(int start, int end) {
			adjMat[start][end] = 1;
			adjMat[end][start] = 1;
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
		
		// SOLUTION METHOD
		// Breadth-first search
		public void minimumSpanningTree() {
			vertexList[0].wasVisited = true;
			theQueue.insert(0);
			int v2;
			 
			while(!(theQueue.isEmpty())) {
				int v1 = theQueue.remove();
				while((v2=getUnvisitedVert(v1)) != -1) {
					vertexList[v2].wasVisited = true;
					theQueue.insert(v2);
					
					displayVertex(v1);
					displayVertex(v2);
					System.out.print(" ");
				}
			}
			
			for(int i = 0; i < nVerts; i++)
				vertexList[i].wasVisited = false;
		}
		// END SOLUTION METHOD
	}
	// END GRAPH CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		// Example graph contains 9 vertices with 12 total edges.
		Graph g = new Graph();
		g.addVertex('A'); // 0
		g.addVertex('B'); // 1
		g.addVertex('C'); // 2
		g.addVertex('D'); // 3
		g.addVertex('E'); // 4
		g.addVertex('F'); // 5
		g.addVertex('G'); // 6
		g.addVertex('H'); // 7
		g.addVertex('I'); // 8
		
		g.addEdge(0, 2); // A-C
		g.addEdge(2, 4); // C-E
		g.addEdge(2, 8); // C-I
		g.addEdge(1, 4); // B-E
		g.addEdge(1, 5); // B-F
		g.addEdge(4, 5); // E-F
		g.addEdge(4, 3); // E-D
		g.addEdge(8, 3); // I-D
		g.addEdge(3, 5); // D-F
		g.addEdge(3, 6); // D-G
		g.addEdge(5, 6); // F-G
		g.addEdge(6, 7); // G-H
		
		System.out.print("Minimum Spanning Tree Edges: ");
		g.minimumSpanningTree();
	}
	// END TEST METHOD
}
// END TEST CLASS
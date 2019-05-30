
public class CircularList {
	private Node head;
	
	// START OF NODE CLASS
	public class Node {
		public int data;
		public Node next, previous;
		
		public Node(int d) {
			data = d;
		}
		
		public void displayLink() {
			System.out.print(data + " ");
		}
	}
	// END OF NODE CLASS
	
	// START OF CIRCULAR LINKED LIST CLASS
	public CircularList() {
		head = null;
	}
	
	public void insert(int data) {
		Node newNode = new Node(data);
		if(head == null)
			head = newNode;
		else
			newNode.next = head;
		head = newNode;
	}
	
	public Node find(int key) {
		Node current = head;
		while(current.data != key) {
			if(current.next == null)
				return null;
			else
				current = current.next;
		}
		return current;
	}
	
	public Node deleteAt(int key) {
		Node previous = null, current = head;
		
		while(current.data != key) {
			
			if(current.next == null)
				return null;
			else {
				previous = current;
				current = current.next;
			}
		}
		
		if(current == head)
			head = head.next;
		else
			previous.next = current.next;
		return current;
		
		
	}
	
	public void displayCircularList() {
		Node current = head;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	// END OF CIRCULAR LINKED LIST CLASS
}

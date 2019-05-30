// THIS CLASS IMPLEMENTS A DEQUE USING A DOUBLY LINKED LIST
public class Deque {
	
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
	
	// START OF DOUBLY LINKED LIST CLASS
	public class DoublyLinkedList {
		private Node head, tail;
		
		public DoublyLinkedList() {
			head = null;
			tail = null;
		}
		
		public boolean isEmpty() {
			return (head == null);
		}
		
		public void insertHead(int data) {
			Node newNode = new Node(data);
			if(isEmpty())
				tail = newNode;
			else
				head.previous = newNode;
			newNode.next = head;
			head = newNode;
			
		}
		
		public void insertTail(int data) {
			Node newNode = new Node(data);
			
			if(isEmpty())
				head = newNode;
			else {
				tail.next = newNode;
				newNode.previous = tail;
			}
			tail = newNode;
		}
		
		public boolean insertAt(int data, int key) {
			Node current = head;
			while(current.data != key) {
				current = current.next;
				if(current == null)
					return false;
			}
			Node newNode = new Node(key);
			if(current == tail) {
				newNode.next = null;
				tail = newNode;
			}
			else {
				newNode.next = current.next;
				current.next.previous = newNode;
			}
			newNode.previous = current;
			current.next = newNode;
			return true;
		}
		
		public Node deleteHead() {
			Node temp = head;
			if(head.next == null)
				tail = null;
			else
				head.next.previous = null;
			head = head.next;
			return temp;
		}
		
		public Node deleteTail() {
			Node temp = tail;
			if(head.next == null)
				head = null;
			else
				tail.previous.next = null;
			tail = tail.previous;
			return temp;
		}
		
		public Node deleteKey(int key) {
			Node current = head;
			while(current.data != key) {
				current = current.next;
				if(current == null)
					return null;
			}
			if(current == head)
				head = current.next;
			else
				current.previous.next = current.next;
			if(current == tail)
				tail = current.previous;
			else
				current.next.previous = current.previous;
			return current;
		}
		
		public void displayForward() {
			Node current = head;
			while(current != null) {
				current.displayLink();
				current = current.next;
			}
		}
		
		public void displayBackward() {
			Node current = tail;
			while(current != null) {
				current.displayLink();
				current = current.previous;
			}
			System.out.println();
		}
	}
	// END OF DOUBLY LINKED LIST CLASS
	
	// START OF DEQUE CLASS
	DoublyLinkedList list;
	
	public Deque() {
		list = new DoublyLinkedList();
	}
	
	public boolean isEmpty() {
		return (list.isEmpty());
	}
	
	public void insertBack(int data) {
		list.insertHead(data);
	}
	
	public void insertFront(int data) {
		list.insertTail(data);
	}
	
	public Node removeBack() {
		Node temp = list.deleteHead();
		return temp;
	}
	
	public Node removeFront() {
		Node temp = list.deleteTail();
		return temp;
	}
	
	public void displayDeque() {
		list.displayBackward();
	}
	// END OF DEQUE CLASS
}

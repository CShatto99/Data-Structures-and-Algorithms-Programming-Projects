// This project implements a stack using a circular linked list.
// TEST CLASS
public class TestClass5_4 {
	
	// NODE CLASS
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
	
	// CIRCULAR LINKED LIST CLASS
	public class CircularList {

		private Node last;
		private int length = 0;
		
		public CircularList() {
			
			last = null;
			
		}
		
		public boolean isEmpty() {
			
			return (length == 0);
			
		}
		
		public int size() {
			
			return length;
			
		}
		
		public void insertFirst(int data) {
			
			Node newNode = new Node(data);
			
			if(last == null)
				last = newNode;
			
			else
				newNode.next = last.next;

			last.next = newNode;
			length++;
			
		}
		
		public void insertLast(int data) {
			
			Node newNode = new Node(data);
			
			if(last == null)
				last = newNode;
			
			else {
				
				newNode.next = last.next;
				last.next = newNode;
				last = newNode;
				
			}
			
			length++;
			
		}
		
		public Node deleteFirst() {
			
			Node first = last.next;
			
			if(last == null)
				return null;
			
			else {
				
				first = first.next;
				last.next = first;
				
			}
			
			length--;
			return first;
			
		}
		
		public void displayCircularList() {
			
			Node first = last.next;
			
			while(first != last) {
				
				first.displayLink();
				first = first.next;
				
			}
			
			first.displayLink();
			System.out.println();
			
		}
		
	}
	// END CIRCULAR LINKED LIST CLASS
	
	// CIRCULAR LINKED LIST STACK CLASS
	public class CircularLinkedStack {
		
		private CircularList list;
		
		public CircularLinkedStack() {
			
			list = new CircularList();
			
		}
		
		public boolean isEmpty() {
			
			return (list.isEmpty());
			
		}
		
		public void push(int data) {
			
			list.insertFirst(data);
			
		}

		public int pop() {
			
			return (list.deleteFirst().data);
			
		}
		
		public void displayCLS() {
			
			list.displayCircularList();
			
		}
		
	}
	// END CIRCULAR LINKED LIST STACK CLASS
	
}
// END TEST CLASS
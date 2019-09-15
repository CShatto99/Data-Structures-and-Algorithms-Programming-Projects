// This project implements a circular linked list.
// TEST CLASS
public class TestClass5_3 {
	
	//  NODE CLASS
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
	// END NODE CLASS
	
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
		
		public Node deleteAfter(int counter) {
			
			Node current = last.next, previous = last;
			
			if(last == null)
				return null;
			
			for(int i = 0; i < counter; i++) {
				
				previous = current;
				current = current.next;
				
			}
			
			Node temp = current;
			previous.next = current.next;
			current = current.next;
			
			last = previous;
			
			length--;
			return temp;
			
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
	
}
// END TEST CLASS
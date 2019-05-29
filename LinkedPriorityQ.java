// PROGRAMMING PROJECT 5.1
public class LinkedPriorityQ {
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
	
	// START OF SORTED LINKED LIST CLASS
	public class SortedList {
		private Node head;
		
		public SortedList() {
			head = null;
		}
		
		public SortedList(Node[] nodeArr) {
			head = null;
			for(int i = 0; i < nodeArr.length; i++) {
				insert(nodeArr[i].data);
			}
		}
		
		public boolean isEmpty() {
			return (head == null);
		}
		
		public void insert(int value) {
			Node newNode = new Node(value);
			Node previous = null, current = head;
			while(current != null && newNode.data > current.data) {
				previous = current;
				current = current.next;
			}
			if(previous == null)
				head = newNode;
			else
				previous.next = newNode;
			newNode.next = current;
		}
		
		public Node remove() {
			Node temp = head;
			head = head.next;
			return temp;
		}
		
		public void displayList() {
			Node current = head;
			while(current != null) {
				current.displayLink();
				current = current.next;
			}
		}
	}
	// END OF SORTED LINKED LIST CLASS
	
	// START OF PRIORITY QUEUE CLASS
	private SortedList list;
	
	public LinkedPriorityQ() {
		list = new SortedList();
	}
	
	public boolean isEmpty() {
		return (list.isEmpty());
	}
	
	public void insert(int data) {
		list.insert(data);
	}
	
	public int remove() {
		Node temp = list.remove();
		return temp.data;
	}
	
	public void displayPriorityQ() {
		list.displayList();
	}
	// END OF PRIORITY QUEUE CLASS
}

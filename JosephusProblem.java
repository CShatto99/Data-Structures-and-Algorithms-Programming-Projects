/*import java.util.Scanner;

public class JosephusProblem {
	
	// START OF NODE CLASS
	public static class Node {
		public int data;
		public Node next;
		
		public Node(int d) {
			data = d;
		}
		
		public void displayLink() {
			System.out.print(data + " ");
		}
	}
	// END OF NODE CLASS
	
	// START OF CIRCULAR LINKED LIST CLASS
	public static class CircularList {
		private Node last;
		private int length;
		
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
			else {
				newNode.next = last.next;
			}
			last.next = newNode;
			length++;
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
	// END OF CIRCULAR LINKED LIST CLASS
	
	// START OF TEST FUNCTION

	public static void main(String[] args) {
		CircularList list = new CircularList();
		int participants, counter;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of participants: ");
		participants = input.nextInt();
		System.out.println(participants);
		System.out.print("Enter the counter for eliminating participants: ");
		counter = input.nextInt();
		System.out.println(counter);
		
		input.close();
		
		
		for(int i = 0; i < participants; i++) {
			int num = (int)(Math.random()*99);
			list.insertFirst(num);
		}
		
		for(int i = 0; i < participants; i++) {
			list.displayCircularList();
			System.out.println("Deleted: " + list.deleteAfter(counter).data);
		}
	}
	// END OF TEST FUNCTION
}
*/

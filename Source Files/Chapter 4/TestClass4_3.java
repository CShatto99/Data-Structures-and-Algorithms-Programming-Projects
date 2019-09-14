// This project implements a double-ended stack.
// TEST METHOD
public class TestClass4_3 {
	public static class DoubleEndedStack {
		
		private int maxSize, top, bottom;
		private long[] arr;
		
		public DoubleEndedStack(int size) {
			
			maxSize = size;
			top = -1;
			bottom = -1;
			arr = new long[maxSize];
			
		}
		
		public void pushTop(long value) {
			
			arr[++top] = value;
			System.out.println("Index: " + top + " " + value);
			
		}
		
		public long popTop() {
			
			return arr[top--];
			
		}
		
		public void pushBottom(long value) {
			
			arr[++bottom] = value;
			System.out.println("Pushed: " + value);
			
		}
		
		public long popBottom() {
			
			return arr[bottom--];
			
		}
		
		public int size() {
			
			return (top+1);
			
		}
		
		public boolean isEmpty() {
			
			return (top == -1);
			
		}
		
		public boolean isFull() {
			
			return (top == maxSize-1);
			
		}
		
		public void display() {
			
			for(int i = 0; i < maxSize; i++) {
				
				long temp = popBottom();
				System.out.print(temp + " ");
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int size = 3;
		DoubleEndedStack s = new DoubleEndedStack(size);
		
		for(int i = 0; i < size; i++) {
			
			long num = (long)(Math.random()*99);
			s.pushBottom(num);
			
		}
		
		System.out.print("Stack (bottom->top): ");
		s.display();
		
	}
	
}

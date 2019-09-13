// TEST CLASS
public class TestClass4_1 {
	
	// QUEUE CLASS
	public static class Queue {
		
		private int maxSize, nItems, front, rear;
		private long[] queArray;
		
		public Queue(int size) {
			
			maxSize = size;
			nItems = 0; 
			front = 0;
			rear = -1;
			queArray = new long[maxSize];
			
		}
		
		public void insert(long value) {
			
			if(rear == maxSize-1)
				rear = -1;
			
			queArray[++rear] = value;
			nItems++;
			
		}
		
		public int size() {
			
			return nItems;
			
		}
		
		public long remove() {
			
			long temp = queArray[front++];
			nItems--;
			
			return temp;
			
		}
		
		public long peekFront() {
			
			return queArray[front];
			
		}
		
		public boolean isEmpty() {
			
			return (nItems == 0);
			
		}
		
		public boolean isFull() {
			
			return (nItems == maxSize);
			
		}
		
		public void display() {
			
			for(int i = 0; i < maxSize; i++) {
				
				long temp = remove();
				System.out.print(temp + " ");
				
			}
			
		}
		
	}
	// END QUEUE CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		
		int size = 10;
		Queue q = new Queue(size);
		
		for(int i = 0; i < size; i++) {
			
			long num = (long)(Math.random()*99);
			q.insert(num);
			
		}
		
		q.display();
	}
	// END TEST METHOD
	
}
// END TEST CLASS

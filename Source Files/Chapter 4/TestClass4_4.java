// This project implements a priority queue with O(1) insertion and O(n^2) deletion.
// TEST CLASS
public class TestClass4_4 {
	
	// PRIORITY QUEUE CLASS
	public static class RevisedPriorityQ {
		
		private int maxSize, nItems;
		private long[] PQArray;
		
		public RevisedPriorityQ(int size) {
			
			maxSize = size;
			nItems = 0;
			PQArray = new long[maxSize];
			
		}
		
		public void insert(long value) {
			
			PQArray[nItems++] = value;
			
		}
		
		public long remove() {
			
			for(int i = 0; i < maxSize-1; i++) {
				
				for(int j = i+1; j < maxSize; j++) {
					
					if(PQArray[i] > PQArray[j]) {
						
						long temp = PQArray[i];
						PQArray[i] = PQArray[j];
						PQArray[j] = temp;
						
					}
					
				}
				
			}
			
			return PQArray[--nItems];
			
		}
		
		public long peekMin() {
			
			return PQArray[nItems-1];
			
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
	// END PRIORITY QUEUE CLASS
	
}
// END TEST CLASS

// This project implements a partition algorithm that uses the rightmost index as the pivot point.
// TEST CLASS
public class TestClass7_1 {
	
	// PARTITION CLASS
	public static class Partition {
		
		private int[] arr;
		private int nElems;
		
		public Partition(int size) {
			
			arr = new int[size];
			nElems = 0;
			
		}
		
		public void insert(int value) {
			
			arr[nElems] = value;
			nElems++;
			
		}
		
		public int size() {
			
			return nElems;
			
		}
		
		public void display() {
			
			for(int i = 0; i < nElems; i++) {
				
				System.out.print(arr[i] + " ");
				
			}
			
			System.out.println();
			
		}
		
		// SOLUTION: Partition method that assigns the pivot to the highest-index element
		public void partitionIt(int left, int right) {
			
			if(size() <= 3)
				manualSort(left, right);
			
			int leftPtr = left, pivot = arr[right];
			
			for(int i = 0; i < nElems-1; i++) {
				
				if(arr[i] < pivot) {
					
					swap(i, leftPtr);
					leftPtr++;
					
				}
				
			}
			
			swap(leftPtr, right);
			
		}
		// END SOLUTION
		
		public void manualSort(int left, int right) {
			
			if(size() == 1)
				return;
			
			if(size() == 2) {
				
				if(arr[left] > arr[right])
					swap(left, right);
				
			}
			
			else {
				
				if(arr[left] > arr[right-1])
					swap(left, right-1);
				
				if(arr[left] > arr[right])
					swap(left, right);
				
				if(arr[right-1] > arr[right])
					swap(right-1, right);
				
			}
			
		}
		
		public void swap(int a, int b) {
			
			int temp = arr[a];
			
			arr[a] = arr[b];
			arr[b] = temp;
			
		}
		
	} 
	// END PARTITION CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		
		int size = 10;
		Partition newArr = new Partition(size);
		
		for(int i = 0; i < size; i++) {
			
			int num = (int)(Math.random()*99);
			newArr.insert(num);
			
		}
		
		newArr.display();
		newArr.partitionIt(0, size-1);
		newArr.display();
		
	}
	// END TEST METHOD
	
}
// END TEST CLASS

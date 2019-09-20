// This project keeps track of the amount of copies and comparisons in a quickSort algorithm.
// TEST CLASS
public class TestClass7_2 {
	
	// QUICKSORT CLASS
	public static class ArrayQuickSort {
		
		private int[] arr;
		private int nItems, copies, comparisons;
		
		public ArrayQuickSort(int size) {
			
			arr = new int[size];
			nItems = 0;
			copies = 0;
			comparisons = 0;
			
		}
		
		public void insert(int value) {
			
			arr[nItems] = value;
			nItems++;
			
		}
		
		public void algoInfo() {
			
			System.out.println("Elements: " + nItems);
			System.out.println("Comparisons: " + comparisons);
			System.out.println("Copies: " + copies);
			
		}
		
		public void display() {
			
			for(int i = 0; i < nItems; i++) {
				
				System.out.print(arr[i] + " ");
				
			}
			
			System.out.println();
			
		}
		
		public void quickSort() {
			
			quickSortCall(0, nItems-1);
			
		}
		
		public void quickSortCall(int left, int right) {
			
			int size = right-left+1;
			
			if(size <= 3)
				manualSort(left, right);
			
			else {
				
				int median = medianOf3(left, right);
				int pivot = partitionIt(left, right, median);
				
				quickSortCall(left, pivot-1);
				quickSortCall(pivot+1, right);
				
			}
			
		}
		
		public int partitionIt(int left, int right, int pivot) {
			
			int leftPtr = left;
			int rightPtr = right - 1;
			
			while(true) {
				
				while(arr[++leftPtr] < pivot) {
					
					copies++;
					
				};
				while(arr[--rightPtr] > pivot) {
					
					copies++;
					
				};
				
				if(leftPtr >= rightPtr)
					break;
				
				else
					swap(leftPtr, rightPtr);
				
			}
			
			swap(leftPtr ,right-1);
			
			return leftPtr;
			
		}
		
		public void manualSort(int left, int right) {
			
			int size = right-left+1;
			
			if(size == 1)
				return;
			
			else if(size == 2) {
				
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
		
		public int medianOf3(int left, int right) {
			
			int center = (left+right) / 2;
			
			if(arr[left] > arr[center])
				swap(left, center);
			
			if(arr[left] > arr[right])
				swap(left, right);
			
			if(arr[center] > arr[right])
				swap(center, right);
			
			swap(center, right-1);
			
			return arr[right-1];
			
		}
		
		public void swap(int a, int b) {
			
			comparisons+=3;
			int temp = arr[a];
			
			arr[a] = arr[b];
			arr[b] = temp;
			
		}
		
	}
	// END QUICKSORT CLASS
	
	// TEST METHOD
		public static void main(String[] args) {
			
			int size = 64;
			ArrayQuickSort newArr = new ArrayQuickSort(size);
			
			for(int i = 0 ; i < size; i++) {
				
				int num = (int)(Math.random()*99);
				newArr.insert(num);
				
			}
			
			newArr.display();
			newArr.quickSort();
			
			newArr.display();
			newArr.algoInfo();
			
		}
		// END TEST METHOD
		
}
// END TEST CLASS
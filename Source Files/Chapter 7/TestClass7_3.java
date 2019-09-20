// This project uses a partition algorithm to find the median of an array.
import java.util.Arrays;
// TEST CLASS
public class TestClass7_3 {

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
		
		public int partitionIt(int left, int right) {
			
			int pivot = arr[(left + right) / 2];
			int leftPtr = left - 1;
			int rightPtr = right + 1;
			
			while(true) {
				
				while(arr[++leftPtr] < pivot);
				while(arr[--rightPtr] > pivot);
				
				if(leftPtr >= rightPtr)
					break;
				
				else
					swap(leftPtr, rightPtr);
				
			}
			
			return rightPtr;
			
		}
		
		public void findMedian() {
			
			median(0, nElems-1);
					
		}
		
		public void median(int left, int right) {
			
			int index = partitionIt(left, right);
			
			System.out.println("Median Value: " + arr[index]);
			System.out.println("Array: " + Arrays.toString(arr));
			
			if(size() == 1)
				return;
			
			else if(right - (index+1) == left + index && size() % 2 == 0) {
				
				median(index, right);
				median(left, index);
				
			}
			else if(index < (size() / 2)) {
				
				median(index, right);
				
			}
			else if(index > (size() / 2)) {
				
				median(left, index);
				
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
		int size = 7;
		Partition newArr = new Partition(size);
		for(int i = 0; i < size; i++) {
			int num = (int)(Math.random()*99);
			newArr.insert(num);
		}
		newArr.findMedian();
	}
	// END TEST METHOD
		
}
// END TEST CLASS
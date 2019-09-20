// This project implements a radix sort.
import java.util.Arrays;
// TEST CLASS
public class TestClass7_5 {
	
	// RADIX SORT METHOD
	public static class Radix {
		
		int arr[];
		int n;
		
		public Radix(int size) {
			
			arr = new int[size];
			n = 0;
			
		}
		
		public void insert(int value) {
			
			arr[n] = value;
			n++;
			
		}
		
		public int getMax() {
			
			int max = arr[0];
			
			for(int i = 0; i < n; i++) {
				
				if(arr[i] > max) {
					max = arr[i];
					
				}
				
			}
			
			return max;
			
		}
		
		public void countSort(int exp) {
			
			int[] output = new int[n];
			int[] count = new int[10];
			
			Arrays.fill(count, 0);
			
			for(int i = 0; i < n; i++)
				count[(arr[i] / exp) % 10]++; 
			
			for(int i = 1; i < 10; i++)
				count[i] += count[i-1];
			
			for(int i = n-1; i >= 0; i--) {
				
				output[count[(arr[i] / exp) % 10] - 1] = arr[i];
				count[(arr[i] / exp) % 10]--;
				
			}
			
			for(int i = 0; i < n; i++)
				arr[i] = output[i];
			
		}
		
		public void radixSort() {
			int max = getMax();
			
			for(int exp = 1; max/exp > 0; exp*=10)
				countSort(exp);
			
		}
		
		public void display() {
			
			System.out.println(Arrays.toString(arr));
			
		}
		
	}
	// END RADIX SORT METHOD
	
	// TEST METHOD
		public static void main(String[] args) {
			
			int size = 10;
			Radix radixSort = new Radix(size);;
			
			for(int i = 0; i < size; i++) {
				
				int num = (int)(Math.random() * 999);
				radixSort.insert(num);
				
			}
			System.out.print("Unsorted Array: ");
			radixSort.display();
			
			radixSort.radixSort();
			
			System.out.print("Sorted Array: ");
			radixSort.display();
			
		}
		// END TEST METHOD
	
}
// END TEST CLASS
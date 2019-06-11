import java.util.Arrays;

public class TestClass7_4 {
	public static void main(String[] args) {
		int size = 9;
		Partition newArr = new Partition(size);
		for(int i = 0; i < size; i++) {
			int num = (int)(Math.random()*99);
			newArr.insert(num);
		}
		newArr.display();
		newArr.randomPartition(0, size-1);
		newArr.display();
	}
	
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
			System.out.println("Array Content: " + Arrays.toString(arr));
		}
		
		public int randomPartition(int left, int right) {
			int randomIndex = (int)(Math.random()*(right - left + 1));
			System.out.println("Random Index: " + randomIndex);
			System.out.println("Random Index Value: " + arr[randomIndex]);

			swap(right, randomIndex);
			return partition(left, right);
		}
		
		public int partition(int left, int right) {
			int pivotValue = arr[right];
			int pivotIndex = left;
			
			for(int i = left; i < right; i++) {
				if(arr[i] <= pivotValue) {
					swap(pivotIndex, i);
					pivotIndex++;
				}
			}
			swap(pivotIndex, right);
			return pivotIndex;
		}
		
		private void swap(int a, int b) {
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
	}
}
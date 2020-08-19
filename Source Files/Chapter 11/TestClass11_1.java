// This project implements a Hash Table that uses quadratic probing
// BEGIN TEST CLASS
public class TestClass11_1 {
	
	// BEGIN DATA ITEM CLASS
	public static class DataItem {
		private int data;
		
		public DataItem(int d) {
			data = d;
		}
		
		public int getKey() {
			return data;
		}
	}
	// END DATA ITEM CLASS
	
	// BEGIN SOLUTION CLASS
	public static class QuadraticProbingHashTable {
		private int arraySize;
		private DataItem[] hashArray;
		private DataItem nonItem;
		
		public QuadraticProbingHashTable(int size) {
			arraySize = size;
			hashArray = new DataItem[arraySize];
			nonItem = new DataItem(-1);
		}
		
		public void displayTable() {
			for(int i = 0; i < arraySize; i++) {
				if(hashArray[i] != null)
					System.out.print(hashArray[i].getKey() + " ");
				else
					System.out.print("** ");
			}
			System.out.println();
		}
		
		public int hashFunc(int key) {
			return (key % arraySize);
		}
		
		public int quadraticProbe(int hashVal, int stepNum) {
			return (hashVal + stepNum*stepNum);
		}
		
		public void insert(DataItem newItem) {
			int stepNum = 0;
			int key = newItem.getKey();
			int hashVal = hashFunc(key);
			
			while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
				stepNum++;
				hashVal = quadraticProbe(hashVal, stepNum);
				hashVal %= arraySize;
			}
			hashArray[hashVal] = newItem;
		}
		
		public DataItem delete(int key) {
			int stepNum = 0;
			int hashVal = hashFunc(key);
			
			while(hashArray[hashVal] != null) {
				if(hashArray[hashVal].getKey() == key) {
					DataItem temp = hashArray[hashVal];
					hashArray[hashVal] = nonItem;
					return temp;
				}
				stepNum++;
				hashVal = quadraticProbe(hashVal, stepNum);
				hashVal %= arraySize;
			}
			return null;
		}
		
		public DataItem find(int key) {
			int stepNum = 0;
			int hashVal = hashFunc(key);
			
			while(hashArray[hashVal] != null) {
				if(hashArray[hashVal].getKey() == key) {
					return hashArray[hashVal];
				}
				stepNum++;
				hashVal = quadraticProbe(hashVal, stepNum);
				hashVal %= arraySize;
			}
			return null;
		}
	}
	// END SOLUTION CLASS
	
	// TEST METHOD
	// main method proves that the hash values are quadratic.
	public static void main(String[] args) {
		QuadraticProbingHashTable t = new QuadraticProbingHashTable(10);
		int key = 235, stepNum = 0;
		int hashVal = t.hashFunc(key);
		System.out.println("Starting hash index: " + hashVal);
		for(int i = 0; i < 10; i++) {
			stepNum++;
			int stepSize = t.quadraticProbe(hashVal, stepNum);
			System.out.println("Step " + i + ": " + stepSize);
		}
	}
	// END TEST METHOD
}
// END TEST CLASS
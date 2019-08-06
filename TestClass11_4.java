// This project performs a rehash on a hash table based on the load factor.
import java.util.Arrays;
// TEST CLASS
public class TestClass11_4 {
	// DATA ITEM CLASS
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
	
	// HASH TABLE CLASS
	public static class HashTable {
		private int arraySize;
		private DataItem[] hashArray;
		private DataItem nonItem;
		private int numItems;
		
		public HashTable(int size) {
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
		
		public void insert(DataItem newItem) {
			int key = newItem.getKey(),
			    hashVal = hashFunc(key),
			    loadFactor = numItems / arraySize;
					
			if(loadFactor > .5) {
				rehash();
			}
			
			while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
				++hashVal;
				hashVal %= arraySize;
			}
			hashArray[hashVal] = newItem;
			numItems++;
		}
		
		// SOLUTION METHODS
		public boolean isPrime(int num) {
			int sqrt = (int)Math.sqrt(num) + 1;
			for(int i = 2; i < sqrt; i++) {
				if(num % i == 0)
					return false;
			}
			return true;
		}
		
		public void rehash() {
			// Create new size that is twice as large
			int newSize = arraySize * 2;
			// While the new size is not a prime number, increment it
			while(!isPrime(newSize))
				newSize++;
			
			// Create a copy of the original hash array
			DataItem tempArray[] = Arrays.copyOf(hashArray, hashArray.length);
			
			// Empty the original array and set the total number of items to zero
			hashArray = new DataItem[newSize];
			numItems = 0;
			
			// For every item in the copy array
			for(int i = 0; i < tempArray.length; i++) {
				// If the item exists or the item was not previous deleted,
				if(tempArray[i] != null && tempArray[i].getKey() != -1)
					// Insert it back into the original array
					insert(tempArray[i]);
			}
		}
		// END SOLUTION METHODS
		
		public DataItem delete(int key) {
			int hashVal = hashFunc(key);
			
			while(hashArray[hashVal] != null) {
				if(hashArray[hashVal].getKey() == key) {
					DataItem temp = hashArray[hashVal];
					hashArray[hashVal] = nonItem;
					return temp;
				}
				++hashVal;
				hashVal %= arraySize;
			}
			return null;
		}
		
		public DataItem find(int key) {
			int hashVal = hashFunc(key);
			
			while(hashArray[hashVal] != null) {
				if(hashArray[hashVal].getKey() == key) {
					return hashArray[hashVal];
				}
				++hashVal;
				hashVal %= arraySize;
			}
			return null;
		}
	}
	// END HASH TABLE CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		int size = 7;
		HashTable ht = new HashTable(size);
		System.out.print("Inserted: ");
		for(int i = 0; i < size+1; i++) {
			int num = (int)(Math.random()*99);
			System.out.print(num + " ");

			DataItem temp = new DataItem(num);
			ht.insert(temp);
		}
	}
	// END TEST METHOD
}
// END TEST CLASS

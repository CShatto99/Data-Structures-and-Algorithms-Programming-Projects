// This project uses a digital-folding hash function to implement a linear probing hash table
// TEST CLASS
public class TestClass11_3 {
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
		
		public HashTable(int s) {
			arraySize = s;
			hashArray = new DataItem[arraySize];
			nonItem = new DataItem(-1);
		}
		
		public void displayTable() {
			for(int i = 0; i < arraySize; i++) {
				System.out.print(hashArray[i].getKey() + "  |  ");
			}
			System.out.println();
		}
		
		// SOLUTION METHOD
		public int digitalFold(int k) {
			// Declare string object variables
			String key = Integer.toString(k),
				   arrSize = Integer.toString(arraySize),
				   group = "";
			
			// Declare integer variables
			int groupSize = arrSize.length() - 1,
				hashVal = 0,
				groupPtr = 0,
				numGroups = key.length() / groupSize; // # of groups in the key
			
			// For every group of numbers 
			for(int i = 0; i < numGroups; i++) {
				// Only execute if the # of indexes left is greater than the group size
				if((key.length() - groupPtr) > groupSize) {
					// Get a substring of the key that is the size of the group size
					group = key.substring(groupPtr, (groupPtr + groupSize));
					// Parse the group and add it to the hash value
					hashVal += Integer.parseInt(group);
					// Increment the group pointer by the group size
					groupPtr += groupSize;
				}
			}
			// Create a substring with remaining indexes and add it the the hash value
			hashVal += Integer.parseInt(key.substring(groupPtr, key.length()));
			return (hashVal %= arraySize);
		}
		// END SOLUTION METHOD
		
		public void insert(DataItem newItem) {
			int key = newItem.getKey();
			int hashVal = digitalFold(key);
			
			while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
				++hashVal;
				hashVal %= arraySize;
			}
			hashArray[hashVal] = newItem;
		}
		
		public DataItem delete(int key) {
			int hashVal = digitalFold(key);
			
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
			int hashVal = digitalFold(key);
			
			while(hashArray[hashVal] != null) {
				if(hashArray[hashVal].getKey() == key)
					return hashArray[hashVal];
				++hashVal;
				hashVal %= arraySize;
			}
			return null;
		}
		
	}
	// END HASH TABLE CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		HashTable t = new HashTable(100);
		t.digitalFold(123456789);
	}
	// END TEST METHOD
}
// END TEST CLASS

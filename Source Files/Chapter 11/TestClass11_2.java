// This project implements a linear probing hash table that stores strings
// BEGIN TEST CLASS
public class TestClass11_2 {
	
	// BEGIN DATA ITEM CLASS
	public static class DataItem {
		private String input;
		
		public DataItem(String s) {
			input = s;
		}
		
		public String getKey() {
			return input;
		}
	}
	// END DATA ITEM CLASS
	
	// BEGIN HASH TABLE CLASS
	public static class HashTable {
		private DataItem[] hashArray;
		private int arraySize;
		private DataItem nonItem;
		
		public HashTable(int size) {
			arraySize = size;
			hashArray = new DataItem[arraySize];
			nonItem = new DataItem("*");
		}
		
		public void displayTable() {
			for(int i = 0; i < arraySize; i++) {
				if(hashArray[i] != null)
					System.out.print(hashArray[i].getKey() + "  |  ");
				else
					System.out.print("null" + "  |  ");
			}
		}
		
		public int hashFunc(String s) {
			int hashVal = 0;
			
			for(int i = 0; i < s.length(); i++) {
				int letter = s.charAt(i) - 96;
				hashVal = (hashVal * 27 + letter) % arraySize;
			}
			return hashVal;
		}
		
		public void insert(DataItem newItem) {
			String key = newItem.getKey();
			int hashVal = hashFunc(key);
			
			while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != "*") {
				++hashVal;
				hashVal %= arraySize;
			}
			hashArray[hashVal] = newItem;
		}
		
		public DataItem delete(String key) {
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
		
		public DataItem find(String key) {
			int hashVal = hashFunc(key);
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
}
// END TEST CLASS
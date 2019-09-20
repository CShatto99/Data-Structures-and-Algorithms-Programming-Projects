// This project solves the classic knapsack problem using recursion.
// TEST CLASS
public class TestClass6_4 {
	
	// TEST METHOD
	public static void main(String[] args) {
		
		int size = 5;
		int[] weights = new int[size], values = {40, 80, 120, 160, 200};
		
		for(int i = 0 ; i < size; i++) {
			
			weights[i] = (i+1) * 10;
			
		}
		
		int maxWeight = 80;
		
		System.out.println(knapsack(maxWeight, weights, values, size));
		
	}
	// END TEST METHOD
	
	public static int knapsack(int maxWeight, int[] weights, int[] values, int index) {
		
		// Base case
		if(index == 0 || maxWeight == 0)
			return 0;
		
		// If weight of the nth item is more than Knapsack capacity maxWeight, then
		// this item cannot be included in t6he optimal solution
		if(weights[index-1] > maxWeight)
			return knapsack(maxWeight, weights, values, index-1);
		
		// Return the maximum of the two cases:
		// (1) nth item included
		// (2) not included
		else
			return Math.max(values[index-1] + knapsack(maxWeight-weights[index-1], weights, values, index-1), 
					   						  knapsack(maxWeight, weights, values, index-1));
		
	}
	
}
// END TEST CLASS
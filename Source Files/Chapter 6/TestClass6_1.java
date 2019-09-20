// This project uses recursion to implement a multiplication function.
// TEST CLASS
public class TestClass6_1 {
	  
	public static void main(String[] args) {
		
		int product = mult(3, 5);
		System.out.println(product);
		
	}
	
	public static int mult(int x, int y) {
		
		if(x == 0 || y == 0)
			return 0;
		
		else
			return (x + mult(x, y-1));
		
	}
	
}
// END TEST CLASS

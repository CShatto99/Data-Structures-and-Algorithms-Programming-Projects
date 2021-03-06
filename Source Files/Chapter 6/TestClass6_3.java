// this project uses recursion to raise integer 'X' to the power of integer 'Y'.
import java.util.Scanner;
// TEST CLASS
public class TestClass6_3 {
	
	// TEST METHOD
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two integers (X and Y) seperated by spaces "
					   + "and X will be raised to the power of Y: ");
		
		int x = input.nextInt();
		int y = input.nextInt();
		
		input.close();
		
		System.out.println();
		System.out.print(x + "^" + y + " = " + power(x, y));
		
	}
	// END TEST METHOD
	
	public static int power(int x, int y) {
		
		if(y == 0)
			return 1;
		
		else
			return(x * power(x, y-1));
		
	}
	
}
// END TEST CLASS
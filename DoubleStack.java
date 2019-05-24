// this project adds items to the top and bottom of a stack and removes items from top and bottom of a stack.
public class DoubleStack {
	private int maxSize, top, bottom;
	private long[] arr;
	
	public DoubleStack(int size) {
		maxSize = size;
		top = -1;
		bottom = -1;
		arr = new long[maxSize];
	}
	
	public void pushTop(long value) { //addToTop
		arr[++top] = value;
	}
	
	public long popTop() { // popTop
		return arr[top--];
	}
	
	public void pushBottom(long value) {
		arr[++bottom] = value;
	}
	
	public long popBottom() {
		return arr[bottom--];
	}
}
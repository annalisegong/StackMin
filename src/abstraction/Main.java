package abstraction;

public class Main {

	public static void main(String[] args) 
	{
		MinStack stack = new MinStack();
		stack.push(4);
		stack.push(5);
		stack.push(8);
		stack.push(10);
		System.out.println("The min element in stack = " + stack.getMin());
	}
}

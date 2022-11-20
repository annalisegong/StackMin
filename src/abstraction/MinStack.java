package abstraction;

public class MinStack extends Stack
{
	private Stack stack;
	private Stack minStack;

	public MinStack()
	{
		stack = new Stack();
		minStack = new Stack();
	}
	
	public void push(int data)
	{
		int min = data;
		if(!minStack.isEmpty() && min > minStack.peek())
		{
			min = minStack.peek();
		}
		stack.push(data);
		minStack.push(min);
	}
	
	public int pop()
	{
		int poppedData = stack.getHeadData();
		if(poppedData == minStack.getHeadData())
		{
			minStack.removeAfter(null);
		}
		stack.removeAfter(null);
		return poppedData;
	}
	
	public int peek()
	{
		int poppedData = this.getHeadData();
		return poppedData;
	}
	
	public int getMin()
	{
		return minStack.peek();
	}
	
	@Override
	public boolean isEmpty()
	{
		int num = this.getLength();
		return num == 0;
	}
}
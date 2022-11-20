package abstraction;

public class Stack extends LinkedList
{
	@Override
	public boolean isEmpty()
	{
		int num = this.getLength();
		return num == 0;
	}
	
	public void push(int data)
	{
		this.prepend(data);
	}
	
	public int pop()
	{
		int poppedData = this.getHeadData();
		this.removeAfter(null);
		return poppedData;
	}
	
	public int min()
	{
		return this.min();
	}
}
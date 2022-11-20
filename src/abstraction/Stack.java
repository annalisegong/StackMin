package abstraction;

public class Stack extends LinkedList
{
	
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
	
	public int peek()
	{
		int poppedData = this.getHeadData();
		return poppedData;
	}
	
	@Override
	public boolean isEmpty()
	{
		int num = this.getLength();
		return num == 0;
	}
}
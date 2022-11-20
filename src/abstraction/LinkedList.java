package abstraction;

public abstract class LinkedList 
{
	private int count;
	protected Node head;
	protected Node tail;
	
	public LinkedList()
	{
		this.head = null;
		this.count = 0;	
	}
	
	protected void prepend(int data)
	{
		Node newNode = new Node(data);
		if(this.count == 0)
		{
			this.head = this.tail = newNode;
			this.count++;
		}
		else
		{
			newNode.setNextNode(this.head);
			this.head = newNode;
			this.count++;
		}
	}
	
	protected void append(int data)
	{
		Node newNode = new Node(data);
		if(this.count == 0)
		{
			this.head = this.tail = newNode;
		}
		else
		{
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
		this.count++;
	}
	
	protected int getHeadData()
	{
		if(this.count == 0)
		{
			return -1;
		}
		return this.head.getData();
	}
	
	public boolean removeHeadData()
	{
		Node currNode = this.head;
		
		if(this.count > 1)
		{
			this.head = currNode.getNextNode();
			currNode.setNextNode(null);
			this.count--;
			return true;
		}
		else if(this.count == 1)
		{
			this.head = this.tail = null;
			currNode.setNextNode(null);
			this.count--;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void removeAfter(Node currNode)
	{
		if(currNode == null && this.head != null)
		{
			//special case to remove header; updates header to nextNode data
			Node nextNode = this.head.getNextNode();
			this.head = nextNode;
			if(nextNode == null)
			{
				//case of last node removed
				this.tail = null;
			}
		}
		else if(currNode.getNextNode() != null)
		{
			//case currNode is not the header or tail
			Node nextNode = currNode.getNextNode().getNextNode();
			currNode.setNextNode(nextNode);
			if(nextNode == null)
			{
				this.tail = currNode;
			}
		}
		count--;
	}
	
	public abstract boolean isEmpty();

	protected int getLength()
	{
		return this.count;
	}
	
	protected void selectionSort()
	{
		Node currNode = new Node(this.head.getData());
		Node i = currNode;
		while(i != this.tail.getNextNode())
		{
			this.head = i;
			Node j = i.getNextNode();
			while(j != null)
			{
				if(j.getData() < this.head.getData())
				{
					this.head = j;
				}
				int temp = j.getData();
				j.setData(this.head.getData());
				this.head.setData(temp);
				
				j = j.getNextNode();	
			}
			i = currNode.getNextNode();
		}
	}
	
	protected int min()
	{
		this.selectionSort();
		return this.head.getData();
	}
	
	@Override
	public String toString()
	{
		String output = "";
		if(this.count > 0)
		{
			output += "head >";
			Node currNode = this.head;
			while(currNode != null)
			{
				output = output + currNode.getData() + " > ";
				currNode = currNode.getNextNode();
			}
			output = output + "tail";
		}
		return output;
	}
}
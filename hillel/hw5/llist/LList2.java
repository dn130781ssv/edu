package edu.hillel.hw5.llist;

public class LList2 implements EList
{
	private Node2 root=new Node2();
	private Node2 node=null;
	int count=1;

	@Override
	public int size()
	{		
		count=1;
		if(root.getNext()==null) count=0;
		else
		{
			node=root.getNext();
			while(node.getNext()!=null)
			{
				node=node.getNext();
				count++;
			}
		}
		System.out.println("count="+count);
		return count;
	}

	@Override
	public void init(int[] ini)
	{	
		if(ini==null||ini.length==0)
		{
			root.setNext(null);
			root.setPrev(null);
		}
		else
		{
			for(int i=0;i<ini.length;i++)
			{
				addEnd(ini[i]);
			}
		}
	}

	public void clear()
	{
		root.setNext(null);
		root.setPrev(null);
		count=0;
	}

	@Override
	public int[] toArray() 
	{
		node=root.getNext();
		int[] tmp = new int[count];
		for (int i = 0; i < count; i++) 
		{
			tmp[i] = node.getData();
			node=node.getNext();
		}
		return tmp;
	}

	@Override
	public int get(int pos) 
	{
		if(count == 0||pos<0||pos>count)
			throw new ListIsEmptyException();
		int i=0;
		node=root.getNext();
		while(i!=pos)
		{	
			node=node.getNext();
			i++;
		}
		return node.getData();
	}

	@Override
	public void set(int pos, int val) 
	{
		if(count == 0||pos<0||pos>count)
			throw new ListIsEmptyException();
		int i=0;
		node=root.getNext();
		while(i<pos)
		{
			node=node.getNext();
			i++;
		}
		node.setData(val);
	}

	@Override
	public void addStart(int val)
	{
		node=new Node2();
		if (root.getNext()==null)
		{
			root.setNext(node);
			root.setPrev(node);
		}	
		else
		{
			root.getNext().setPrev(node);
			node.setNext(root.getNext());
			root.setNext(node);
		}
		node.setData(val);
		count++;
	}

	@Override
	public void addEnd(int val)
	{
		node=new Node2();
		if (root.getPrev()==null)
		{
			root.setNext(node);
			root.setPrev(node);
		}	
		else
		{
			Node2 tmp=root.getPrev();
			tmp.setNext(node);
			node.setPrev(tmp);
			root.setPrev(node);
		}
		node.setData(val);
		count++;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if(pos<0||pos>count)
			throw new ListIsEmptyException();

		node=new Node2();

		if (root.getNext()==null)
		{
			root.setNext(node);
			node.setData(val);
		}

		else if(pos==0) addStart(val);
		else if(pos==count) addEnd(val);

		else
		{
			node=root.getNext();
			Node2 newNode2=new Node2();
			int i=0;

			while(i<pos-1)
			{
				i++;
				node=node.getNext();
			}
			newNode2.setNext(node.getNext());
			node.getNext().setPrev(node);
			node.setNext(newNode2);
			node.setPrev(node);
			newNode2.setData(val);
			count++;
		}
	}

	@Override
	public int delStart()
	{		
		if(count == 0)
			throw new ListIsEmptyException();
		
		int ret=0;
		if (count==1)
		{
			ret = root.getNext().getData();
			clear();
		}
		else
		{
			node=root.getNext();
			ret = node.getData();
			node=node.getNext();
			node.setPrev(null);
			root.setNext(node);
			count--;
		}
		return ret;
	}

	@Override
	public int delEnd()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		int ret=0;
		if(size()==1) 
		{
			ret=root.getNext().getData();	
			root.setNext(null);
		}
		else
		{
			Node2 node=new Node2();
			node.setNext(root.getNext());
			int i=-1;
			do
			{
				i++;
				node=node.getNext();
			}while(i<size()-2);
			ret = node.getNext().getData();
			node.setNext(null);
		}
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if(size()==0||pos<0||pos>size())
			throw new ListIsEmptyException();
		int ret=0;
		Node2 node=new Node2();
		node.setNext(root.getNext());
		if(size()==1) 
		{
			ret=root.getNext().getData();	
			root.setNext(null);
		}
		else
		{
			int i=-1;
			do
			{
				i++;
				node=node.getNext();
			}while(i<pos-1);
			ret=node.getNext().getData();
			if(size()==2) 
			{
				root.setNext(node.getNext());
			}
			else
			{
				node.setNext(node.getNext().getNext());	
			}

		}
		return ret;
	}

	@Override
	public int min()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		int min = root.getNext().getData();
		Node2 node=new Node2();
		node.setNext(root.getNext());
		do
		{
			node=node.getNext();
			if (node.getData()<min) min=node.getData();
		}while(node.getNext()!=null);
		return min;
	}

	@Override
	public int max()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		int max = root.getNext().getData();
		Node2 node=new Node2();
		node.setNext(root.getNext());
		do
		{
			node=node.getNext();
			if (node.getData()>max) max=node.getData();
		}while(node.getNext()!=null);
		return max;
	}

	@Override
	public int minInd()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		Node2 node=new Node2();
		node.setNext(root.getNext());
		int min = root.getNext().getData();
		int minInd=0;
		int i=-1;
		do
		{
			i++;
			node=node.getNext();
			if (node.getData()<min)
			{
				minInd=i;
				min=node.getData();
			}
		}while(node.getNext()!=null);
		return minInd;
	}

	@Override
	public int maxInd()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		Node2 node=new Node2();
		node.setNext(root.getNext());
		int max = root.getNext().getData();
		int maxInd=0;
		int i=-1;
		do
		{
			i++;
			node=node.getNext();
			if (node.getData()>max)
			{
				maxInd=i;
				max=node.getData();
			}
		}while(node.getNext()!=null);
		return maxInd;
	}

	@Override
	public void sort()
	{
		Node2 nodeA=new Node2();
		Node2 nodeB=new Node2();

		nodeA.setNext(root.getNext());

		for(int i=0;i<size()-1;i++)
		{
			nodeA=nodeA.getNext();	
			nodeB=nodeA.getNext();
			for(int j=i+1;j<size();j++)
			{
				if (nodeA.getData()>nodeB.getData())
				{
					int temp=nodeA.getData();
					nodeA.setData(nodeB.getData());
					nodeB.setData(temp);
				}
				nodeB=nodeB.getNext();
			}
		}
	}

	@Override
	public void reverse()
	{
		Node2 nodeA=new Node2();
		Node2 nodeB=new Node2();

		nodeA.setNext(root.getNext());
		int temp=0;
		for(int i=0;i<size()/2;i++)
		{
			nodeA=nodeA.getNext();	
			nodeB=nodeA.getNext();
			for(int j=i;j<(size()-i-2);j++)
			{
				nodeB=nodeB.getNext();
			}
			temp=nodeA.getData();
			nodeA.setData(nodeB.getData());
			nodeB.setData(temp);
		}
	}

	@Override
	public void halfReverse()
	{	
		int d = (size()%2==0)?0:1;
		Node2 nodeA=new Node2();
		Node2 nodeB=new Node2();

		nodeA.setNext(root.getNext());
		int temp=0;
		for(int i=0;i<size()/2;i++)
		{
			nodeA=nodeA.getNext();	
			nodeB=root.getNext();
			size();
			for(int j=0; j<size()/2+d+i;j++)
			{
				nodeB=nodeB.getNext();
			}
			temp=nodeA.getData();
			nodeA.setData(nodeB.getData());
			nodeB.setData(temp);	
		}
	}

}
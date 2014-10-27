package dataStructures;

public class LinkedListDS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node node1 = new node();
		node node2 = new node();
		node node3 = new node();
		node node4 = new node();
		node node5 = new node();
			node1.setData(1);
			node2.setData(2);
			node3.setData(3);
			node4.setData(4);
			node5.setData(5);
			
			
			
			System.out.println(list.getData());
	}

}
class node
{
	private int data;
	private node next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedListOperations getNext() {
		return next;
	}
	public void setNext(node next) {
		this.next = next;
	}
}
class LinkedListOperations
{
	private int data;
	private LinkedListOperations next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedListOperations getNext() {
		return next;
	}
	public void setNext(LinkedListOperations next) {
		this.next = next;
	}
	int ListLength(LinkedListOperations headNode)
	{
		int length = 0;
		LinkedListOperations currentNode = headNode;
		while(currentNode!=null)
		{
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	LinkedListOperations insert(LinkedListOperations headNode, LinkedListOperations insertNode, int position)
	{
		if(headNode == null)
		{
			return insertNode;
		}
		if(position >ListLength(headNode) || position <1)
		{
			return insertNode;
		}
		if(position ==1)
		{
			insertNode.setNext(headNode);
			return headNode;
		}
		else
		{
			LinkedListOperations currentNode = headNode;
			for(int i=1;i<position-1;i++)
			{
				currentNode = currentNode.getNext();
			}
			LinkedListOperations nextnode = currentNode.getNext();
			currentNode.setNext(insertNode);
			insertNode.setNext(nextnode);
		}
		return headNode;
	}
	LinkedListOperations delete(LinkedListOperations headNode,  int position)
	{
		if(position >ListLength(headNode) || position <1)
		{
			return headNode;
		}
		if(position == 1)
		{
			LinkedListOperations tempNode = headNode.getNext();
			headNode = null;
			return tempNode;
		}
		else
		{
			LinkedListOperations currentNode = headNode;
			for(int i=1;i<position-1;i++)
			{
				currentNode = currentNode.getNext();
			}
			LinkedListOperations deleteNode = currentNode.getNext();
			currentNode.setNext(deleteNode.getNext());
			deleteNode =null;
		}
		return headNode;
	}
}

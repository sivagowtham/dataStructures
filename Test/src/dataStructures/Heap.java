package dataStructures;

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {3,1,2,5,1,1,1,3,2,8,7};
		HeapOperations h = new HeapOperations(11,1,input);
		h.print();
		for(int i=(h.count-1)/2;i>=0;i--)
			h.heapify(i);
		h.print();
		
	}
}
class HeapOperations
{
	int[] array;
	int count = 0;
	int capacity =0;
	int heapType;
	public HeapOperations(int capacity, int heapType, int[] inputArray)
	{
		this.capacity = capacity;
		count = capacity;
		this.heapType = heapType;
		this.array = new int[capacity];
		this.array = inputArray;
	}
	public int leftChild(int i)
	{
		int left = 2*i+1;
		if(left >= count)
		{
			return -1;
		}
		return left;
	}
	int rightChild(int i)
	{
		int right = 2*i+2;
		if(right >= count)
		{
			return -1;
		}
		return right;
	}
	public int parent(int i)
	{
		if(i<=0 || i>=count)
			return -1;
		int parent = (i-1)/2;
		return parent;
	}
	public void heapify(int i)
	{
		int l,r,max,temp;
		l=leftChild(i);
		r=rightChild(i);
		if(l!=-1 && array[i]<array[l])
		{
			max = l;
		}
		else
			max = i;
		if(r!=-1 && array[r]>array[max])
			max = r;
		if(max!=i)
		{
			temp = array[i];
			array[i] = array[max];
			array[max] = temp;
			heapify(max);
		}
	}
	public void print()
	{
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
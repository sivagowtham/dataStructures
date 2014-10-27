package testPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter array");
		Scanner inp = new Scanner(System.in);
		//String noOfNodes = inp.nextLine();
		//String inputString = "1234";
		//String[] strarray = inputString.split("");
		String[] strarray = {"1","5","3","4"};
		ArrayList<Integer> inputIntegers = new ArrayList<Integer>();
		for (String string : strarray) {
			inputIntegers.add(Integer.parseInt(string));
		}
		BalancedBinaryTree tree = new BalancedBinaryTree(inputIntegers);
		printInorder(tree.get_root());
	}
	public static void printInorder(Node root){ 
		printInOrderRec(root); 
		System.out.println(""); 
	} 

	private static void printInOrderRec(Node currRoot)
	{ 
		if ( currRoot == null ){ return; } 
		printInOrderRec(currRoot.getLeft()); 
		System.out.print(currRoot.getInfo()+", "); 
		printInOrderRec(currRoot.getRight()); } 
}



class Node
{
	private int _info;
	private Node _left;
	private Node _right;

	public Node()
	{
		//this._info = Integer.MIN_VALUE;
		this._left = null;
		this._right = null;
	}


	public int getInfo()
	{
		return _info;
	}

	public void setInfo(int _info)
	{
		this._info = _info;
	}

	public Node getLeft()
	{
		return _left;
	}

	public void setLeft(Node _left)
	{
		this._left = _left;
	}

	public Node getRight()
	{
		return _right;
	}

	public void setRight(Node _right)
	{
		this._right = _right;
	}  
}
class BalancedBinaryTree
{
	private ArrayList<Integer> _numbers;
	private Node _root;

	public Node get_root() {
		return _root;
	}

	public BalancedBinaryTree(ArrayList<Integer> numbers)
	{
		this._numbers = new ArrayList<>();
		this._numbers.addAll(numbers);
		Collections.sort(this._numbers);
		//System.out.println("ddddddd"+this._numbers);
		this._root = new Node();

		this.create(this._root, 0, this._numbers.size());
	}

	private void create(Node tree, int i, int j)
	{
		if (i < j)
		{
			int m = i + (j - i) / 2;

			tree.setInfo(this._numbers.get(m));

			tree.setLeft(new Node());
			create(tree.getLeft(), i, m);

			tree.setRight(new Node());
			create(tree.getRight(), m + 1, j);
		}
	}
}


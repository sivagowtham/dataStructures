package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode leftChild = new TreeNode(2); TreeNode rightChild = new TreeNode(3);TreeNode temp = new TreeNode(4);	
		root.setLeftNode(leftChild);
		root.setRightNode(rightChild);
		rightChild.setLeftNode(temp);
		Traversals traverse = new Traversals();
		traverse.preOrderTraversal(root);
		//traverse.levelOrderTraversal(root);
		traverse.deleteNode(rightChild,root);
		traverse.preOrderTraversal(root);
	} 
}
class Traversals
{
	void preOrderTraversal(TreeNode root)
	{
		if(root!= null)
		{
			System.out.println(root.getData());
			preOrderTraversal(root.getLeftNode());
			preOrderTraversal(root.getRightNode());
		}
	}
	void levelOrderTraversal(TreeNode root)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			TreeNode temp = (TreeNode) q.remove();
			System.out.println(temp.getData());
			if(temp.getLeftNode()!=null)
			{
				q.add(temp.getLeftNode());
			}
			if(temp.getRightNode()!=null)
			{
				q.add(temp.getRightNode());
			}
		}
	}
	void deleteNode(TreeNode node,TreeNode root)
	{
		TreeNode deepestNode = null;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			deepestNode = q.remove();
			if(deepestNode.getLeftNode()!=null)
			{
				q.add(deepestNode.getLeftNode());
			}
			if(deepestNode.getRightNode()!=null)
			{
				q.add(deepestNode.getRightNode());	
			}
		}
		System.out.println("deepest Node"+ deepestNode.getData());
		q.clear();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode temp = q.remove();
			if(temp.getLeftNode().getData()==node.getData())
			{
				temp.getLeftNode().setData(deepestNode.getData());
				deepestNode= null;
				break;
			}
			else if(temp.getRightNode().getData()==node.getData())
			{
				temp.getRightNode().setData(deepestNode.getData());
				deepestNode=null;
				break;
			}
			
			else
			{
				if(temp.getLeftNode()!=null)
				{
					q.add(temp.getLeftNode());
				}
				if(temp.getRightNode()!=null)
				{
					q.add(temp.getRightNode());	
				}
			}
		}
	}
}
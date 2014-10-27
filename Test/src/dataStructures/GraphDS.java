package dataStructures;

import java.util.Stack;

public class GraphDS {

	public static void main(String[] args) {

		Graph g = new Graph();
		g.addVertex('a');
		g.addVertex('b');
		g.addVertex('c');
		g.addVertex('d');
		g.addVertex('e');
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.dfs();
		
	}

}
class Vertex
{
	public char lable;
	public boolean visited;
	Vertex(char lab)
	{
		this.lable = lab;
		visited = false;
	}
}
class Graph
{
	public final int maxVertex=20;
	public int vertexCount;
	public Vertex vertexList[];
	private int adjMatrix[][];
	public Graph()
	{
		vertexList = new Vertex[maxVertex];
		vertexCount = 0;
		adjMatrix = new int[maxVertex][maxVertex];
		for(int i =0;i<maxVertex;i++){
			for(int j=0;j<maxVertex;j++)
			{
				adjMatrix[i][j] = 0;
			}
		}
	}
	public void addVertex(char a)
	{
		vertexList[vertexCount++] = new Vertex(a);
	}
	public void addEdge(int start,int end)
	{
		adjMatrix[start][end]= 1;
		adjMatrix[end][start]= 1;
	}
	public void displayVertex(int a)
	{
		System.out.println(vertexList[a].lable);
	}
	public void dfs()
	{
		Stack s = new Stack();
		if(vertexList[0]!=null)
		{
			vertexList[0].visited = true;
			displayVertex(0);
			s.push(0);
		}
		while(!s.isEmpty())
		{
			int v= getAdjUnvisitedVertex((int) s.peek());
			if(v == -1)
			{
				s.pop();
			}
			else
			{
				vertexList[v].visited = true;
				displayVertex(v);
				s.push(v);
			}
		}
	}
	public int getAdjUnvisitedVertex(int v)
	{
		for(int i=0;i<vertexCount;i++)
		{
			if(adjMatrix[v][i]==1 && vertexList[i].visited == false)
			{
				return i;
			}
		}
		return -1;
	}
}

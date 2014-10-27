package testPackage;

import java.util.*;

public class QueueReversal
{
	public static void main(String[] args)
	{
		Queue<String> q = new LinkedList();
		q.add("a");
		q.add("b");
		q.add("c");
		q.add("d");
		q.add("e");
		System.out.println("initial"+q);
		Stack<String> s = new Stack<String>();
		int i=0;
		while(!q.isEmpty()&&i<3)
		{
			i++;
			s.push(q.remove());
		}
		System.out.println("Stack  "+s );
		while(!s.isEmpty())
		{
			q.add(s.pop());
		}
		for (int j = 0; j < q.size()-3; j++) {
			q.add(q.remove());
		}
		System.out.println("Final"+q);
	}
	TreeSet t = new TreeSet();
	
}
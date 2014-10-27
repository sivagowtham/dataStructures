package testPackage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class MagicForest {
	/**
	 * @param nodes Number of nodes in the magic forest. Nodes are numbered 0 .. nodes-1.
	 * @param edges List of edges.
	 */
	Hashtable<Integer, ArrayList<Integer>> ht = new Hashtable();
	public MagicForest(int nodes, List<Edge> edges) {

		//ArrayList inputEdges = (ArrayList) edges;
		
		ArrayList temp1 = new ArrayList();
		temp1.add(0);
		ht.put(0, temp1);

		for (Edge edge : edges) {
		
			if(ht.containsKey(edge.getFrom()))
			{
				ArrayList<Integer> temp = ht.get(edge.getFrom());
				temp.add(edge.getTo());
				ht.put(edge.getFrom(), temp);
			}
			else
			{
				ArrayList<Integer> temp = new ArrayList();
				temp.add(edge.getTo());	
				ht.put(edge.getFrom(), temp );
			}
		}
		 Set<Integer> keys = ht.keySet();
		for(Integer key: keys)
		{
			ArrayList<Integer> test = new ArrayList<Integer>();
			test.add(key);
			for (Integer integer : ht.get(key)) {
				test.add(integer);
			}
			if(ht.contains(test))
			{
				//System.out.println(test);
				 Set<Integer> keys1= ht.keySet();
					for(Integer key1: keys1)
					{
						if(test.equals(ht.get(key1)))
						{
//							System.out.println(ht);
//							System.out.println(key1+"    "+ ht.get(key1));
							for (Integer integer : test) {
								ht.remove(integer);
							}
							ht.remove(key1);
//							System.out.println(ht);
//							System.out.println(ht.size());
						}
					}
			}
		}
		//System.out.println(ht);
	}

	public int countTrees() {
		//throw new UnsupportedOperationException("Waiting to be implemented.");
		return ht.size();
	}

	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(1, 2));
		edges.add(new Edge(3, 4));
		edges.add(new Edge(3, 5));
		edges.add(new Edge(4, 5));
		edges.add(new Edge(6, 7));
		edges.add(new Edge(6, 8));
		edges.add(new Edge(6, 9));
		
		MagicForest magicForest = new MagicForest(10, edges);
		System.out.println(magicForest.countTrees());
	}
}

class Edge {
	private int from;
	private int to;

	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}

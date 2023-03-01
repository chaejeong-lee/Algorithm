import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 프림 알고리즘
 * @author lcj52
 *
 */
public class Main {
	
	static class Node implements Comparable<Node>{
		int to;
		int from;
		int value;
		
		
		public Node(int to, int from, int value) {
			this.to = to;
			this.from = from;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	
	static int V, E;
	static int[] parent;
	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		
		for(int i=1;i<V+1;i++) {
			parent[i] = i;
		}
		
		Queue<Node> pq = new PriorityQueue<>();
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Node(a, b, c));
		}
		
		int size = pq.size();
		
		for(int i=0;i<size;i++) {
			Node nd = pq.poll();
			int to = find(nd.to);
			int from = find(nd.from);
			
			if(!isSame(to, from)) {
				total += nd.value;
				union(nd.to, nd.from);
			}
		}
		System.out.println(total);
	}

	private static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) parent[y] = x;
	}
	
	private static boolean isSame(int x, int y) {
		x = find(x);
		y = find(y);
		if(x== y) return true;
		else return false;
	}
}

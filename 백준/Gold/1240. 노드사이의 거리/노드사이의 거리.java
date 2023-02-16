import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int destination;
		int distance;
		
		public Node(int destination, int distance) {
			this.destination = destination;
			this.distance = distance;
		}	
	}
	
	private static ArrayList<Node>[] lists;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N+1];
		
		for(int i=0;i<N;i++) {
			lists[i+1]= new ArrayList<>(); 
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			lists[node1].add(new Node(node2, dist));
			lists[node2].add(new Node(node1, dist));
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			dfs(start, end, -1, 0);
			System.out.println(answer);
		}
	}
	
	private static void dfs(int start, int end, int previous, int cost) {
		if(start == end) {
			answer = cost;
		}
		
		for(Node node : lists[end]) {
			if(node.destination != previous) {
				dfs(start, node.destination, end, cost+node.distance);
			}
		}
	}
}
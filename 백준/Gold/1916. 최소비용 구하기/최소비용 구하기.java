import java.io.*;
import java.util.*;

public class Main {
	
	static class Point implements Comparable<Point> {
		int to, cost;
		
		public Point(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M, answer;
	static int[] costs;
	static boolean[] visited;
	static final int MAX_VALUE = 10_000_001;
	static ArrayList<Point>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list= new ArrayList[N+1];
		costs = new int[N+1];
		visited = new boolean[N+1];
		
		Arrays.fill(costs, MAX_VALUE);
		
		for(int i=1; i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Point(end, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int startPoint = Integer.parseInt(st.nextToken());
		int endPoint = Integer.parseInt(st.nextToken());
		
		dijkstra(startPoint, endPoint);
		System.out.println(answer);
	}
	
	public static void dijkstra(int start, int end) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(start, 0));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.to == end) {
				answer = cur.cost;
				return;
			}
			
			visited[cur.to] = true;
			
			for(Point next: list[cur.to]) {
				if(!visited[next.to]) {
					pq.add(new Point(next.to, cur.cost + next.cost));
				}
			}
		}
	}

}
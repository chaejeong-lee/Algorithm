import java.util.*;
import java.io.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int to, cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;// 오름차순
		}
	}

	private static int N, M;
	private static char[] schools;
	private static ArrayList<Node>[] list;
	private static boolean[] visited;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		// MST Prime 알고리즘 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		schools = new char[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			schools[i] = st.nextToken().charAt(0);
		}
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(schools[start] != schools[end]) {
				list[start].add(new Node(end, cost));
				list[end].add(new Node(start, cost));
			}
		}
		
		solution();
		boolean check = false;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				check = true;
				break;
			}
		}
		
		if(check) System.out.println(-1);
		else System.out.println(answer);
	}
	
	private static void solution() {
		PriorityQueue<Node> pq =  new PriorityQueue<>();
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int to = cur.to;
			int cost = cur.cost;
			
			if(visited[to]) continue;
			visited[to] = true;
			answer += cost;
			
			for(Node next: list[to]) {
				if(!visited[next.to]) {
					pq.add(new Node(next.to, next.cost));
				}
			}
		}		
	}

}
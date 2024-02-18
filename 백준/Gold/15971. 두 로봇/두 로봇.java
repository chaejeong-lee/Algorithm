import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class node{
		int x, w, max;

		public node(int x, int w, int max) {
			super();
			this.x = x;
			this.w = w;
			this.max = max;
		}

		public node(int x, int w) {
			super();
			this.x = x;
			this.w = w;
		}
	}

	static int n;
	static List<node>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		
		graph = new ArrayList[n];
		
		for(int i=0;i<n;i++) {
			graph[i] = new ArrayList<node>();
		}
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			graph[start].add(new node(end, w));
			graph[end].add(new node(start, w));
		}
		
		bfs(a, b);
	}

	private static void bfs(int a, int b) {
		Queue<node> q = new LinkedList<node>();
		boolean[] visited = new boolean[n];
		
		visited[a] = true;
		q.add(new node(a, 0, 0));
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			if(cur.x == b) {
				System.out.println(cur.w - cur.max);
				break;
			}
			
			for(node next: graph[cur.x]) {
				if(!visited[next.x]) {
					visited[next.x] = true;
					q.add(new node(next.x, cur.w + next.w, Math.max(cur.max, next.w)));
				}
			}
		}
	}
}

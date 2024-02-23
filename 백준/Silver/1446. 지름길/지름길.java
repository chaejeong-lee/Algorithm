import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int start, end, distance;
		
		public Point(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
	}
	
	private static int N, D;
	private static ArrayList<Point> graph;
	private static boolean[] visited;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			if(end-start > distance)
				graph.add(new Point(start, end, distance));
		}
		visited = new boolean[graph.size()];
		
		dfs(0, 0);
		System.out.println(answer);
	}
	
	private static void dfs(int now, int dist) {
		if(now > D) return;
		else if(now == D) {
			answer = Math.min(answer, dist);
			return;
		}
		else {
			answer = Math.min(answer, dist + (D-now));
		}
		
		for(int i=0;i<graph.size();i++) {
			if(!visited[i]) {
				Point cur = graph.get(i);
				if(cur.start == now) {
					visited[i] = true;
					dfs(cur.end, dist + cur.distance);
					visited[i] = false;
				}
			}
		}
		
		dfs(now+1, dist+1);
	}
}
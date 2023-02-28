import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point{
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static ArrayList<Point>[] list;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1;i<V+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) break;
				list[n].add(new Point(num, Integer.parseInt(st.nextToken())));
			}
		}
		
		visited[1] = true;
		dfs(1);
		System.out.println(max);
	}

	private static int dfs(int start) {
		int val = 0;
		int secVal = 0;
		
		for(Point p : list[start]) {
			if(visited[p.x]) continue;
			
			visited[p.x] = true;
			int dVal = dfs(p.x)+p.y;
			
			if(val<dVal) {
				secVal = val;
				val = dVal;
			}
			else if(secVal < dVal) {
				secVal = dVal;
			}
		}
		max = Math.max(max, val + secVal);
		return val;
	}
}

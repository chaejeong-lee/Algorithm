import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, min;
	static int[][] map;
	static ArrayList<Point> chickens, homes;//치킨집 위치, 집 위치
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		chickens = new ArrayList<>();//치킨집 위치
		homes = new ArrayList<>();//집 위치
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken()); 
				if(map[i][j] == 1 ) homes.add(new Point(i, j));
				else if(map[i][j]== 2) chickens.add(new Point(i, j));
			}
		}
		
		visited = new boolean[chickens.size()];
		min = Integer.MAX_VALUE;
		selectChicken(0, 0);
		System.out.println(min);
		
	}
	
	private static void selectChicken(int start, int cnt) {
		if(cnt == M) {
			int res = 0;
			for(int i=0;i<homes.size();i++) {
				int tmp = Integer.MAX_VALUE;
				for(int j=0;j<chickens.size();j++) {
					if(visited[j]) {
						int distance = Math.abs(homes.get(i).x - chickens.get(j).x)+Math.abs(homes.get(i).y-chickens.get(j).y);
						tmp = Math.min(tmp, distance);
					}
				}
				res += tmp;
			}
			min = Math.min(min, res);
			return;
		}
		
		for(int i=start;i<chickens.size();i++) {
			visited[i]= true;
			selectChicken(i+1, cnt+1);
			visited[i]= false; 
		}
	}

}

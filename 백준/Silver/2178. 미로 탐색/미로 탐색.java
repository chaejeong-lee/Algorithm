import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		 int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(map[N-1][M-1]);
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int d=0;d<4;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if(nr < 0|| nc < 0 || nr>=N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 0) continue;
				
				q.add(new Point(nr, nc));
				map[nr][nc] = map[cur.r][cur.c]+1;
				visited[nr][nc] = true;
			}
			
		}
		
	}

}
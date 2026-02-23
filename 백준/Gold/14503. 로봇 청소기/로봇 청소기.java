import java.io.*;
import java.util.*;

public class Main {
	
	static class Point {
		int r, c, d;
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	static int N, M;
	static Point robot;
	static int[][] map;
	static int answer = 0;
	
	// 북 -> 동 -> 남 -> 서
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		robot = new Point(r, c, d);
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝
		
		startToClean();
		System.out.println(answer);
	}

	public static void startToClean() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(robot.r, robot.c, robot.d));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(map[cur.r][cur.c] == 0) {
	            map[cur.r][cur.c] = 2;
	            answer++;
	        }
			
			// 청소되지 않은 빈칸이 없는 경우
			boolean foundEmpty = false;
			int nextD = cur.d;
			
			for(int d = 0; d<4; d++) {
				nextD = (nextD + 3) % 4;
				int nr = cur.r + dr[nextD];
				int nc = cur.c + dc[nextD];
				
				// 범위를 들어오는지 && 청소를 안 했는지
				if(isRange(nr, nc) && map[nr][nc] == 0) {
					foundEmpty = true;
					q.add(new Point(nr, nc, nextD));
					break;
				}
			}
			
			if(!foundEmpty) {
				// 청소할 칸이 없는 경우 => 후진
				int nr = cur.r + dr[(cur.d + 2)%4];
				int nc = cur.c + dc[(cur.d + 2)%4];
				
				// 뒤로 갈 수 없는 경우
				if(isRange(nr, nc) && map[nr][nc] != 1) {
					q.add(new Point(nr, nc, cur.d));
				}
				else {
					return;
				}
			}
		}
	}
	
	public static boolean isRange(int r, int c) {
		return (0<= r && r < N && 0<=c && c<M);
	}
}
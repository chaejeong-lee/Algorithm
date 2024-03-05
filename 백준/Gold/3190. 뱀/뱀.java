import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int r, c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Direction {
		int time, dir;
		
		Direction(int time, int dir){
			this.time = time;
			this.dir = dir;
		}
	}

	private static int N, K;		// N : 보드의 크기, K : 사과의 개수
	private static int L;			// L : 뱀의 방향 변환 횟수
	private static int[][] map;
	private static Queue<Point> snake;
	private static ArrayList<Direction> timeDirs;
	
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		snake = new LinkedList<>();
		timeDirs = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			// 사과의 위치 행, 열
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			int dir = C.equals("D")?1:-1;
			timeDirs.add(new Direction(X, dir));
		}
		
		solution();
	}

	private static void solution() {

		map[0][0] = -1;
		int time = 0;
		int turn = 0;
		int curDir = 0;
		
		Point snakeHead = new Point(0, 0);
		snake.add(snakeHead);
		
		while(true) {
			time++;
			int nr = snakeHead.r + dr[curDir];
			int nc = snakeHead.c + dc[curDir];
			
			if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc] == -1) break;
			
			if(map[nr][nc] != 1) {
				Point tail = snake.poll();
				map[tail.r][tail.c] = 0;
			}
			
			snakeHead = new Point(nr,nc);
			snake.add(snakeHead);
			map[nr][nc] = -1;
			
			if(turn < L && timeDirs.get(turn).time == time) {
				curDir = (curDir + timeDirs.get(turn).dir)%4;
				curDir = curDir == -1 ? 3 : curDir;
				turn++;
			}
		}
		System.out.println(time);
	}
}
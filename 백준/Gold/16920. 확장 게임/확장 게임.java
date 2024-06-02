import java.util.*;
import java.io.*;

public class Main {
	private static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static int N, M, P;
	private static int[] castle;
	private static int[] distance;
	private static char[][] map;
	private static Queue<Point>[] qs;

	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 입력 시작
		N = Integer.parseInt(st.nextToken()); // 맵 크기 NxM
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken()); // P: 플레이어 수

		map = new char[N][M];
		castle = new int[P+1];
		distance = new int[P+1];
		qs = new LinkedList[P+1];
		
		for(int i=1;i<=P;i++) qs[i] = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=P;i++) distance[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				char c = str.charAt(j);
				if(c >= '0' && c <= '9') {
					int player = c - '0';
					castle[player]++;
					qs[player].add(new Point(i, j));
				}
				map[i][j] = c;
			}
		}
		
		playGame();
		
		for(int i=1;i<=P;i++) {
			System.out.print(castle[i]+" ");
		}
	}
	
	private static void playGame() {
		int player = 1;
		int round = 0;
		
		while(true) {
			int maxDist = distance[player];
			int cnt = expandCastle(qs[player], maxDist, player);
			
			castle[player] += cnt;
			round += cnt;
			
			player++;
			if(player == P+1) {
				if(round == 0) break;
				round = 0;
				player = 1;
			}
		}
	}

	private static int expandCastle(Queue<Point> q, int maxDist, int player) {
		int cnt = 0;
		int dist = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				Point cur = q.poll();
				for(int d = 0; d<4;d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if(!isRange(nr, nc)) continue;
					if(map[nr][nc] == '.') {
						q.add(new Point(nr, nc));
						map[nr][nc] = (char)(player+'0');
						cnt++;
					}
				}
			}
			
			dist++;
			if(dist>maxDist) break;
		}
		return cnt;
	}
	
	private static boolean isRange(int r, int c) {
		return (0 <= r && r < N && 0 <= c && c < M);
	}
}
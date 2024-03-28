import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static char[][] map;
	private static boolean[][] visited;
	private static int dotTotalCnt, answer;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		String input = "";
		int tc = 1;
		while((input= br.readLine()) != null){
			st = new StringTokenizer(input," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			visited = new boolean[N][M];
			dotTotalCnt = 0;
			answer = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '.') dotTotalCnt++;
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] == '.') {
						visited[i][j] = true;
						backtracking(i, j, 1, 0);
						visited[i][j] = false;
					}
				}
			}
			
			if(answer == Integer.MAX_VALUE) 
				sb.append("Case "+tc+": "+(-1)).append("\n");
			else
				sb.append("Case "+tc+": "+answer).append("\n");
			tc++;
			
		}
		System.out.print(sb);
	}

	private static void backtracking(int r, int c, int dotCnt, int moves) {
		if(dotCnt == dotTotalCnt) {
			answer = answer > moves? moves:answer;
			return;
		}
		
		for(int d = 0; d<4;d++) {
			int moveCnt = 0;
			int curR = r;
			int curC = c;
			
			while(true) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				// 범위를 벗어났는지 체크
				if(nr<0 || nc<0 || nr>=N || nc>=M) break;
				// 방문했는지, 장애물이 있는지 체크
				if(visited[nr][nc] || map[nr][nc] == '*') break;
				
				visited[nr][nc] = true;
				moveCnt++;
				curR = nr;
				curC = nc;
			}
			
			if(r == curR && c == curC) continue;
			// 다음 단계 진행
			backtracking(curR, curC, dotCnt+moveCnt, moves+1);
			// 지나온 길 돌아가기
			for(int i=0;i<moveCnt;i++) {
				visited[curR][curC] = false;
				curR = curR-dr[d];
				curC = curC-dc[d];
			}
		}
	}
}
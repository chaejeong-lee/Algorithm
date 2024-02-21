import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int H = 5, W = 9;
	private static char[][] map;
	private static int remainPin, move;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T;tc++) {
			map = new char[H][W];
			
			int pin = 0;
			for(int i=0;i<H;i++) {
				String str = br.readLine();
				for(int j=0;j<W;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'o') pin++;
				}
			}
			
			remainPin = pin;
			br.readLine();
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j] == 'o') dfs(i, j, pin, 0);
				}
			}
			
			sb.append(remainPin+" "+move).append("\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int r, int c, int remain, int moveCnt) {
		if(remain <= remainPin) {
			remainPin = remain;
			move = moveCnt;
		}
		
		for(int d = 0;d <4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isRange(nr, nc) && map[nr][nc]=='o') {
				int nnr = nr + dr[d];
				int nnc = nc + dc[d];
				
				if(isRange(nnr, nnc) && map[nnr][nnc] == '.') {
					map[r][c] = '.';
					map[nr][nc] = '.';
					map[nnr][nnc] = 'o';
					
					for(int i=0;i<H;i++) {
						for(int j=0;j<W;j++) {
							if(map[i][j] == 'o') dfs(i, j, remain-1, moveCnt+1);
						}
					}

					map[r][c] = 'o';
					map[nr][nc] = 'o';
					map[nnr][nnc] = '.';
				}
			}
		}
	}
	
	private static boolean isRange(int r, int c) {
		return (r>=0 && c>=0 && r<H && c<W);
	}
}

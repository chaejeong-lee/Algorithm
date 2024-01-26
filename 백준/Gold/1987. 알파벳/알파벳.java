import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static boolean[] visited = new boolean[26];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int answer = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		if(R==1 && C == 1) {
			System.out.println(answer);
		}else {
			dfs(0, 0, 0);
			System.out.println(answer);
		}
	}
	
	private static void dfs(int cnt, int r, int c) {
		if(visited[(int)(map[r][c]-'A')]) {
			answer = Math.max(answer, cnt);
			return;
		}
		
		visited[(int)(map[r][c]-'A')] = true;
		
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc <C)
				dfs(cnt+1, nr, nc);
		}

		visited[(int)(map[r][c]-'A')] = false;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int C, R, K;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());//가로
		R = Integer.parseInt(st.nextToken());//세로
		
		K = Integer.parseInt(br.readLine());//어떤 관객의 대기 번호
		
		if(K>C*R) System.out.println("0");
		else {
			boolean[][] visited = new boolean[R][C];
			int cnt = 0, d = 0;
			int r=R-1, c =0;
			while(++cnt != K) {
				visited[r][c] = true;
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				
				if(nr<0 || nc<0 || nc >=C || nr >= R || visited[nr][nc]) {
					d = ++d%4;
					nr = r + dir[d][0];
					nc = c + dir[d][1];
				}
				
				r = nr;
				c = nc;
			}
			System.out.println((c+1)+" "+(R-r));
		}
	}

}
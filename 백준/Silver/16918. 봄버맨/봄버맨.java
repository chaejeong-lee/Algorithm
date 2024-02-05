import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, N;
	static char[][] map;
	static int[][] bomberMap;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		bomberMap = new int[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'O') {
					bomberMap[i][j] = 3;
				}
			}
		}
		
		bomberMan();
		
		for(int i=0;i<R;i++) {
			System.out.println(map[i]);
		}
	}

	private static void bomberMan() {
		int time = 1;
		
		
		while(time < N+1) {
			///time이 홀수일 경우 => 폭탄 설치
			if(time % 2 == 0) {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(map[i][j] == '.') {
							map[i][j] = 'O';
							bomberMap[i][j] = time + 3;
						}
					}
				}
			}
			else {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(bomberMap[i][j] == time) {
							map[i][j] = '.';
							for(int d=0;d<4;d++) {
								int nr = i + dr[d];
								int nc = j + dc[d];
								
								if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
								
								if(map[nr][nc] == 'O' && bomberMap[nr][nc] != time) {
									map[nr][nc]='.';
									bomberMap[nr][nc] = 0;
								}
							}
						}
					}
				}
			}
			time++;
		}
	}
}
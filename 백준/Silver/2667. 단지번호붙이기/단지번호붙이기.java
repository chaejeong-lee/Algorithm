import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int complexNuber =0, totalCnt = 0;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> answer = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<map.length;i++) {
			String s = br.readLine();
			for(int j=0;j<map[i].length;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] == false && map[i][j]== 1) {
					complexNuber = 0;
					totalCnt++;
					DFS(i, j);
					answer.add(complexNuber);
				}
			}
		}
		
		Collections.sort(answer);
		sb.append(totalCnt+"\n");
		for(int n:answer) {
			sb.append(n+"\n");
		}
		
		System.out.print(sb);
	}
	
	private static void DFS(int x, int y) {
		visited[x][y] = true;
		map[x][y] = totalCnt;
		complexNuber++;
		
		for(int i=0;i<dir.length;i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			if(0<= nx && 0<=ny && nx<N && ny<N && visited[nx][ny] == false && map[nx][ny]==1) {
				visited[nx][ny] = true;
				map[nx][ny] = totalCnt;
				DFS(nx, ny);
			}
		}
	}
}

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N= Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + cur;
			}
		}
		
		int answer = map[1][1];
		int size = -1;
		while(size++ != N) {
			for(int i=1;i<=N-size;i++) {
				for(int j=1;j<=N-size;j++) {
					int sum = map[i+size][j+size] - map[i-1][j+size] - map[i+size][j-1] + map[i-1][j-1];
					answer = Math.max(sum, answer);
				}
			}
		}
		System.out.println(answer);
	}

}
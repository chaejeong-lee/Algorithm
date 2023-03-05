import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] adj;
	static int[][] pointAdj;
	
	//최대 집하장 개수 : 200개, 집하장간 경로 최대 개수 : 10000
	private static final int INF = 200*10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());//집하장 개수
		M = Integer.parseInt(st.nextToken());//집하장 경로 개수
		
		adj = new int[N+1][N+1];
		pointAdj = new int[N+1][N+1];
		
		for(int i=1;i<adj.length;i++) {
			Arrays.fill(adj[i], INF);
		}
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				pointAdj[i][j] = j;
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adj[start][end] = adj[end][start] = Math.min(adj[start][end], weight);
		}
		
		for(int k=1;k<N+1;k++) {
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++) {
					if(adj[i][j] > (adj[i][k] + adj[k][j])) {
						adj[i][j] = adj[i][k] + adj[k][j];
						pointAdj[i][j] = pointAdj[i][k];
					}
				}
			}
		}
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				if(i==j) {
					sb.append("-").append(" ");
					continue;
				}
				sb.append(pointAdj[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int idx, score;
		
		public Node(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}
	}

	private static int N, M, K;
	private static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());	// K: 항공로의 개수
		
		dp = new int[M+1][N+1];
		List<Node>[] boards = new List[N+1];
		
		for(int i=0;i<=N;i++) {
			boards[i] = new ArrayList<>();
		}
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a>b) continue;
			
			boards[a].add(new Node(b, c));
		}
		
		int result = 0;
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		
		int cnt = 1;
		
		while(!q.isEmpty() && cnt < M) {
			int size = q.size();
			
			while(size-- > 0) {
				int nowIdx = q.poll();
				
				for(Node nNode: boards[nowIdx]) {
					int nIdx = nNode.idx;
					int nScore =dp[cnt][nowIdx] + nNode.score;
					
					if(dp[cnt+1][nIdx] >= nScore) continue;
					
					dp[cnt+1][nIdx] = nScore;
					
					q.add(nIdx);
				}
			}
			cnt++;
		}
		
		for(int i=2;i<=M;i++) {
			result = Integer.max(result, dp[i][N]);
		}
		
		System.out.println(result);
	}

}
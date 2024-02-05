import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] studentsChoice;
	static boolean[] visited, finished;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0;tc<T;tc++) {
			n = Integer.parseInt(br.readLine());
			
			studentsChoice = new int[n+1];
			visited = new boolean[n+1];
			finished = new boolean[n+1];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1;i<=n;i++) {
				studentsChoice[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			for(int i=1;i<=n;i++) {
				if(finished[i]) continue;
				dfs(i);
			}
			
			sb.append(n-answer).append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void dfs(int cIdx) {
		if(finished[cIdx]) return;
		if(visited[cIdx]) {
			finished[cIdx] = true;
			answer++;
		}
		
		visited[cIdx] = true;
		dfs(studentsChoice[cIdx]);
		finished[cIdx] = true;
		visited[cIdx] = false;
	}

}
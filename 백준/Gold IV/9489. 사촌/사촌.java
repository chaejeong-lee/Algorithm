import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if(n==0 && k==0) break;
			
			int target = 0;
			int[] arr = new int[n+1];
			int[] parent = new int[n+1];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1;i<=n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] == k) target = i;
			}
			
			int answer = 0;
			parent[0] = -1;
			parent[1] = 0;//루트 노드 부모 X
			
			int idx = 1;
			for(int i=2;i<=n;i++) {
				parent[i] = idx;
				if(i<n && arr[i]+1 != arr[i+1]) idx++;
			}
			
			for(int i=1;i<=n;i++) {
				if(parent[parent[i]]==parent[parent[target]] && parent[i] != parent[target]) answer++;
			}
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}
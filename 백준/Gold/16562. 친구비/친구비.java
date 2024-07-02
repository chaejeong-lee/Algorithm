import java.io.*;
import java.util.*;

public class Main {

	public static int N, M, k;
	public static int[] arr;
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		parent = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v, w);
		}
		
		boolean[] visited = new boolean[N+1];
		int answer = 0;
		for(int i=1;i<=N;i++) {
			int rootIdx = find(i);
			
			if(visited[rootIdx]) {
				visited[i] = true;
				continue;
			}
			
			answer += arr[rootIdx];
			visited[rootIdx] = true;
			visited[i] = true;
		}
		
		if(answer > k) System.out.println("Oh no");
		else System.out.println(answer);
	}

	public static int find(int idx) {
		if(parent[idx] == idx) {
			return idx;
		}
		return find(parent[idx]);
	}
	
	public static void union(int idx1, int idx2) {
		int parent1 = find(idx1);
		int parent2 = find(idx2);
		
		if(arr[parent1] >= arr[parent2]) {
			parent[parent1] = parent2;
		}else {
			parent[parent2] = parent1;
		}
	}
}
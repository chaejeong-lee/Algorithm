import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[] dp, arr, select;
	private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	private static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		dp = new int[n+1];
		select = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			list.add(new ArrayList<>());
			tree.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		buildTree(1, -1);
		
		int t1 = dp(1, 0);
		int t2 = dp(1, 1);
		
		if(t1>t2) select[1] = 0;
		else select[1] = 1;
		
		sb.append(Math.max(t1, t2)).append("\n");
		
		findNode(1, select[1]);
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}
		System.out.println(sb);
	}
	
	private static int dp(int now, int node) {
		int result = 0;
		if(node == 1) {
			for(int next: tree.get(now)) {
				result += dp(next, 0);
			}
			return result + arr[now];
		}
		else {
			for(int next: tree.get(now)) {
				int t1 = dp(next, 0);
				int t2 = dp(next, 1);
				
				if(t1>t2) select[next] = 0;
				else select[next] = 1;
				
				result += Math.max(t1, t2);
			}
			return result;
		}
	}

	private static void buildTree(int now, int p) {
		for(int child : list.get(now)) {
			if(child != p) {
				tree.get(now).add(child);
				buildTree(child, now);
			}
		}
	}
	
	private static void findNode(int now, int node) {
		if(node == 0) {
			for(int next: tree.get(now)) {
				findNode(next, select[next]);
			}
		}
		else if(node == 1) {
			pq.offer(now);
			for(int next: tree.get(now)) {
				findNode(next, 0);
			}
		}
	}
}
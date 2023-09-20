import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static int n;
	static int[] cost;
	static int[] indegree;
	static int[] times;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		indegree = new int[n+1];
		times = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i]= new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			indegree[i] = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<indegree[i];j++) {
				list[Integer.parseInt(st.nextToken())].add(i);
			}
		}
		
		cost = new int[n+1];
		topologySort();
		
		int result = 0;
		for(int i=1;i<=n;i++) {
			result = Math.max(result, cost[i]);
		}
        System.out.println(result);
	}

	private static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(indegree[i] == 0) {
				q.offer(i);
				cost[i] = times[i];
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0;i<list[cur].size();i++) {
				int next = list[cur].get(i);
				cost[next] = Math.max(cost[cur] + times[next], cost[next]);
				indegree[next]--;
				if(indegree[next] == 0) q.offer(next);
			}
		}
	}
}

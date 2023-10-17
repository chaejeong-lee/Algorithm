import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int x;
        int time;
        
        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    
	static int n, k;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		bfs();
		System.out.println(min);
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(n, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			visited[cur.x] = true;
			if(cur.x == k) min = Math.min(min, cur.time);
            
            if(cur.x * 2 <= 100000 && visited[cur.x * 2] == false) 
            	q.offer(new Node(cur.x * 2, cur.time));
            if(cur.x + 1 <= 100000 && visited[cur.x + 1] == false) 
            	q.offer(new Node(cur.x + 1, cur.time + 1));
            if(cur.x - 1 >= 0 && visited[cur.x - 1] == false) 
            	q.offer(new Node(cur.x - 1, cur.time + 1));
		}
	}
}
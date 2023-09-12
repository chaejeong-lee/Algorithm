import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, l, r;
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Node> list;
	static int answer = 0;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());// 크기
		l = Integer.parseInt(st.nextToken());// 차 최대
		r = Integer.parseInt(st.nextToken());// 차 최소
		
		board = new int[n][n];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move();
		System.out.println(answer);
	}
	
	private static void move() {
		while(true) {
			boolean isMove = false;
			visited = new boolean[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j]) {
						int sum = bfs(i, j);//열릴 수 있는 국경선 확인 => 인구수
						if(list.size() > 1) {
							changePopulation(sum);
							isMove = true;
						}
					}
				}
			}
			if(!isMove) return;
			answer++;
		}
	}
	
	private static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();
		
		q.offer(new Node(x, y));
		list.add(new Node(x, y));
		visited[x][y] = true;
		
		int sum = board[x][y];
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]) {
					int diff = Math.abs(board[current.x][current.y]-board[nx][ny]);
					if(l<=diff && diff <= r) {
						q.offer(new Node(nx, ny));
						list.add(new Node(nx, ny));
						sum += board[nx][ny];
						visited[nx][ny] = true;
					}
				}
			}
		}
		return sum;
	}
	
	private static void changePopulation(int sum) {
		int avg = sum / list.size();
		for(Node n : list) {
			board[n.x][n.y] = avg;
		}
	}

}
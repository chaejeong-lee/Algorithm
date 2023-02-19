import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	private static int N, M;
	private static int[][] donut;
	private static int[][] dir = {{0, -1}, {0,1}, {-1, 0}, {1, 0}};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		donut = new int[N][M];
		
		for(int i=0;i<donut.length;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<donut[i].length;j++) {
				donut[i][j]= Integer.parseInt(st.nextToken()); 
			}
		}
		
		checkDonut();
	}

	private static void checkDonut() {
		int answer = 0;
		
		for(int i=0;i<donut.length;i++) {
			for(int j=0;j<donut[i].length;j++) {
				if(donut[i][j]==1) continue;
				
				answer++;
				Queue<Point> queue = new ArrayDeque<>();
				queue.add(new Point(i, j));
//				donut[i][j] = 0;
				while(!queue.isEmpty()) {
					int x = queue.peek().x;
					int y = queue.poll().y;
					for(int k=0;k<dir.length;k++) {
						int nx = x + dir[k][0];
						int ny = y + dir[k][1];
						if(nx<0) nx += N;
						if(ny<0) ny += M;
						
						nx%=N;
						ny%=M;
						
						if(donut[nx][ny]==1) continue;
						donut[nx][ny] = 1;
						queue.add(new Point(nx, ny));
					}
				}
			}
		}
		System.out.println(answer);
	}
}

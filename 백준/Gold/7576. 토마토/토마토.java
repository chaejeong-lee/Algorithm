import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N, M;
	static int[][] box;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static Queue<Point> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		box = new int[M][N];
		
		q = new LinkedList<Point>();
		
		for(int i=0;i<box.length;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<box[i].length;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]== 1) q.add(new Point(i, j));
			}
		}
		
		System.out.println(bfs());
		
	}
	
	private static int bfs() {
		while(!q.isEmpty()) {
			Point p = q.remove();
			
			int x = p.x;
			int y = p.y;
			
			for(int i=0;i<4;i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				
				if(nx>=0 && ny >= 0 && nx <M && ny<N) {
					if(box[nx][ny]==0) {
						q.add(new Point(nx, ny));
						box[nx][ny] = box[x][y]+1;
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(box[i][j]==0) return -1;
				else {
					max = Integer.max(max, box[i][j]);
				}
			}
		}
		
		return max-1;
	}

}

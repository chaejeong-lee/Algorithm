import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int location, count;
		
		public Point(int location, int count) {
			this.location = location;
			this.count = count;
		}
	}
	
	public static int N, K;
	public static int minTime, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// N: 수빈의 위치
		K = Integer.parseInt(st.nextToken());	// K: 동생의 위치
		
		bfs();
		System.out.println(minTime+"\n" + cnt);
	}

	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		int[] visited = new int[100001];
		q.add(new Point(N, 0));
		visited[N] = 1;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(cur.location == K) {
				if(cnt == 0) {
					// 맨 처음에 개수가 없을 값
					minTime = cur.count;
				}
				if(minTime == cur.count) {
					cnt++;
				}
			}
			
			int[] nextLocation = {cur.location+1, cur.location-1, cur.location*2};
			
			for(int i=0;i<nextLocation.length;i++) {
				int nextCur = nextLocation[i];
				
				if(nextCur<0 || nextCur > 100000) continue;
				if(visited[nextCur] == 0 || visited[nextCur] == cur.count+1) {
					visited[nextCur] = cur.count+1;
					q.add(new Point(nextCur, cur.count+1));
				}
			}
		}
	}
}
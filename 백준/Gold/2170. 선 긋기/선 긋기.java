import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point> {
		int s, e;
		
		public Point(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Point o) {
			if(this.s == o.s) return this.e - o.e;
			return this.s - o.s;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> pq = new PriorityQueue();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.add(new Point(s, e));
		}
		
		long answer = 0;
		Point cur = pq.poll();
		int start = cur.s;
		int end = cur.e;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(end < cur.s) {
				answer += (end - start);
				start = cur.s;
				end = cur.e;
				continue;
			}
			
			if(cur.e > end) 
				end = cur.e;
		}
		answer += (end - start);
		System.out.println(answer);
	}

}

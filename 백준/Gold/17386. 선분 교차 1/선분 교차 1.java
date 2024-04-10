import java.util.*;
import java.io.*;

public class Main {
	
	static class Point {
		long x, y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Point A = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point B = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

		st = new StringTokenizer(br.readLine()," ");
		Point C = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point D = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		
		int answer = 0;
		if((CCW(A.x, A.y, B.x, B.y, C.x, C.y) * CCW(A.x, A.y, B.x, B.y, D.x, D.y) < 0)
				&& (CCW(C.x, C.y, D.x, D.y, A.x, A.y) * CCW(C.x, C.y, D.x, D.y, B.x, B.y) <0)) answer = 1;
		System.out.println(answer);
	}

	private static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
		return ((x1*y2 + x2*y3 + x3*y1) - (y1*x2 + y2*x3 + y3*x1)<0?1:-1);
	}
}

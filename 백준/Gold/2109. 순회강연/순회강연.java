import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			points[i] = new Point(p, d);
		}
		
		Arrays.sort(points, (p1, p2)->(p1.x==p2.x)?p2.y-p1.y:p2.x-p1.x);
		
		int answer = 0;
		boolean[] check = new boolean[10001];
		for(int i=0;i<N;i++) {
			for(int j=points[i].y;j>=1;j--) {
				if(!check[j]) {
					check[j] = true;
					answer += points[i].x;
					break;
				}
			}
		}
		System.out.println(answer);
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		int[] dists = new int[k+1];
		
		for(int tc = 0;tc<k+1;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			
			int dist = 0;
			
			if(dir == 1) dist = loc;
			else if(dir == 2) dist = 2*n + m - loc;
			else if(dir == 3) dist = 2*(n+m) - loc;
			else if(dir == 4) dist = n + loc;
			dists[tc] = dist;
		}
		
		int myDist = dists[k];
		int sum = 0;
		for(int i=0;i<k;i++) {
			int clockDist = Math.abs(myDist - dists[i]);
			sum += Math.min(clockDist, 2*(n+m)-clockDist);
		}
		System.out.println(sum);
	}

}
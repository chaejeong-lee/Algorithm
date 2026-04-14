import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] visitCnt = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			visitCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i = 0;i<X;i++) {
			sum += visitCnt[i];
		}
		
		int max = sum;
		int cnt = 1;
		
		int lp = 0;
		for(int rp = X; rp<N;rp++) {
			sum += visitCnt[rp];
			sum -= visitCnt[lp++];
			
			if(sum == max) cnt++;
			else if(sum > max) {
				max = sum;
				cnt = 1;
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(max+"\n"+cnt);
		}
	}
}

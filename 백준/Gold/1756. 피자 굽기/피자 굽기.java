import java.util.*;
import java.io.*;

public class Main {
	
	private static int D, N;
	private static int[] ovenLength;
	private static int maxOven;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		D = Integer.parseInt(st.nextToken());	// D: 오븐의 깊이
		N = Integer.parseInt(st.nextToken());	// N: 피자 반죽의 개수
		ovenLength = new int[D+1];
		maxOven = D;
		
		st = new StringTokenizer(br.readLine()," ");
		ovenLength[0] = Integer.MAX_VALUE;
		for(int i=1;i<D+1;i++) {
			ovenLength[i] = Integer.parseInt(st.nextToken());
			ovenLength[i] = Math.min(ovenLength[i - 1], ovenLength[i]);
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			int size = Integer.parseInt(st.nextToken());
			ovenCheck(size);
		}
		System.out.println(maxOven);
	}
	
	private static void ovenCheck(int curPizzaLength) {
		boolean check = false;
		
		for(int i=maxOven;i>0;i--) {
			if(ovenLength[i]>=curPizzaLength) {
				maxOven = i;
				ovenLength[i] = 0;
				check = true;
				break;
			}
		}
		
		if(!check) {
			maxOven = 0;
		}
	}

}
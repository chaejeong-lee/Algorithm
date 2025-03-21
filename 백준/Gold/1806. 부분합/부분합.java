import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int len = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;
		
		while(start < N) {			
			if(sum >= S) {
				len = Math.min(len, end - start);
				sum -= arr[start++];
			} else {
				if(end == N) break;
				sum += arr[end++];
			}
		}
		
		System.out.println(len == Integer.MAX_VALUE ? 0 : len);
	}

}
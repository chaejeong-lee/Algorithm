import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i= 0 ; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		Integer[] B = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i= 0 ; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B, Collections.reverseOrder());
		int sum = 0;
		
		for(int i= 0 ; i<N ; i++) {
			sum += (A[i]*B[i]);
		}
		System.out.println(sum);
		br.close();
	}

}
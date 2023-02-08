import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int gcdVal = arr[1]-arr[0];
		
		for(int i =2 ; i<N ; i++) {
			gcdVal = GCD(gcdVal, arr[i]-arr[i-1]);
		}
		
		for(int i = 2 ; i <= gcdVal ; i++) {
			if(gcdVal % i == 0) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
	}

	static int GCD(int A, int B) {
		while(B != 0 ) {
			int r = A%B;
			A = B;
			B = r;
		}
		return A;
	}
}
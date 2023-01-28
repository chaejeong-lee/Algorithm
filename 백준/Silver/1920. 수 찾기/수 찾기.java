import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i=0;i<N;i++) {
			A[i]= sc.nextInt(); 
		}
		Arrays.sort(A);
		
		int M = sc.nextInt();
		
		for(int i=0;i<M;i++) {
			int answer = 0;
			int start = 0;
			int end = N-1;
			
			int num = sc.nextInt();
			
			while(start<=end) {
				int mid = (start+end)/2;
				if(A[mid]==num) {
					answer = 1;
					break;
				}
				if(A[mid]>num) end = mid -1;
				else start = mid+1;
			}
			sb.append(answer+"\n");
		}
		System.out.print(sb);
	}

}
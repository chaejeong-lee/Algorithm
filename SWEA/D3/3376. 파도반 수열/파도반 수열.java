import java.util.*;

public class Solution {
	
	public static long[] arr = new long[100];
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 2;
		
		for(int test_case=1;test_case<=T;test_case++) {
			int N = sc.nextInt();
			
			sb.append("#"+test_case+" "+pibo(N)+"\n");
		}
		System.out.print(sb);
	}
	
	private static long pibo(int num) {
		for(int i=4;i<num;i++) {
			arr[i]= arr[i-2]+arr[i-3]; 
		}
		return arr[num-1];
	}
	
}
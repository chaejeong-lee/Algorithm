import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			long N = sc.nextInt();
			
			long s2 = N*N;
			long s3 = s2+N;
			long s1 = s3/2;
			sb.append("#"+test_case+" "+s1+" "+s2+" "+s3+"\n");
		}
		System.out.print(sb);
	}
	
}
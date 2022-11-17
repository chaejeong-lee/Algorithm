import java.util.*;

import org.omg.CORBA._IDLTypeStub;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			int D = sc.nextInt();
			int H = sc.nextInt();
			int M = sc.nextInt();
			
			long answer = minch(D-11, H-11, M-11);
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.print(sb);
	}
	
	private static long minch(int d, int h, int m) {
		long answer=0;
		
		if(d<0 || d==0 && h<0 || d==0 && h==0 && m<0) {
			answer=-1;
		}else {
			answer += (d*24*60);
			answer += (h*60);
			answer += m;
		}
		
		return answer;
	}
}
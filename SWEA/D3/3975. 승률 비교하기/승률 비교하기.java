import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			int A = sc.nextInt();//alice의 이긴 수
			int B = sc.nextInt();//alice의 플레이 판 수
			int C = sc.nextInt();//bob의 이긴 수
			int D = sc.nextInt();//bob의 플레이 판 수
			
			double winningRateA = A/(double)B*100;
			double winningRateB = C/(double)D*100;
			
			String answer="";
			if(winningRateA>winningRateB)
				answer = "ALICE";
			else if(winningRateA<winningRateB)
				answer="BOB";
			else {
				answer="DRAW";
			}
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.print(sb);
	}
	
}
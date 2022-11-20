import java.util.*;

public class Solution {
	static int result;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();//몇 명
			int M = sc.nextInt();//몇 초에
			int K = sc.nextInt();//몇 개를 구울 수 있는
			
			boolean check=true;
			
			int[] person = new int[N];
			for(int i=0;i<N;i++) {
				person[i] = sc.nextInt();
			}
			
			Arrays.sort(person);
			
			String answer = "Possible";
			
			for(int i=1;i<=N;i++) {
				int time = person[i-1];
				int made = time/M*K-i;//해당 시점의 사람 수만큼 빵을 사감
				if(made<0) {
					answer="Impossible";
					break;
				}
			}
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.print(sb);
	}
	
}
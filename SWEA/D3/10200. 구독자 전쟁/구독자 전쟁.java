import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());//사람
			int A = Integer.parseInt(st.nextToken());//'P'채널 구독 - '네'
			int B = Integer.parseInt(st.nextToken());//'Q'채널 구독 - '네'
			
			int min = Math.min(A, B);
            int max =A+B>N?A+B-N:0;
			sb.append("#"+test_case+" "+min+" "+max+"\n");
		}
		System.out.print(sb);
	}
}
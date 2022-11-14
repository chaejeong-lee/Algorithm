import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			int num = Integer.parseInt(s.charAt(s.length()-1)+"");
			if(num%2==0)
				sb.append("#"+test_case+" Even\n");
			else
				sb.append("#"+test_case+" Odd\n");
		}
		System.out.print(sb);
	}
}
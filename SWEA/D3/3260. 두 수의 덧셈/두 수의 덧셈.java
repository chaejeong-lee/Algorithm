import java.math.BigInteger;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			BigInteger num1 = sc.nextBigInteger();
			BigInteger num2 = sc.nextBigInteger();
			
			sb.append("#"+test_case+" "+num1.add(num2)+"\n");
		}
		System.out.print(sb);
	}
}
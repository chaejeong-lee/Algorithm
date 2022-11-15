import java.math.BigInteger;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			BigInteger a = sc.nextBigInteger();
			BigInteger b= sc.nextBigInteger();
			
			sb.append("#"+test_case+" "+((a.multiply(a)).divide((b.multiply(b))))+"\n");
		}
		System.out.println(sb);
	}

}
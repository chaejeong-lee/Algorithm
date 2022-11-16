import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			String s = sc.next();
			sb.append("#"+test_case+" "+check(s)+"\n");
		}
		System.out.print(sb);
	}
	
	private static String check(String s) {
		if(s.length()==1) {
			return s;
		}else {
			int[] arr = new int[s.length()];
			int sum=0;
			for(int i=0;i<s.length();i++) {
				arr[i]=Integer.parseInt(s.charAt(i)+"");
				sum += arr[i];
			}
			return check(Integer.toString(sum));
		}
	}
}
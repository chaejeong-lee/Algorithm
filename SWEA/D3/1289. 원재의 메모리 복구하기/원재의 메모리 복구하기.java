import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String s=sc.next();
			int[] arr = new int[s.length()];
			for(int i=0;i<arr.length;i++) {
				arr[i] = Integer.parseInt(s.charAt(i)+"");
			}
			
			int idx=arr[0];
			for(int i=arr.length-1;i>0;i--) {
				if(arr[i]!=arr[i-1]) {
					idx++;
				}
			}
			
			sb.append("#"+test_case+" "+idx+"\n");
		}
		System.out.print(sb);
	}
}
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			ArrayList<String> str = new ArrayList<>();
			
			String s = sc.next();
			
			for(int i=0;i<s.length();i++) {
				str.add(s.charAt(i)+"");
			}
			
			int h = sc.nextInt();//하이픈 개수
			int[] arr = new int[h];
			
			for(int i=0; i<arr.length;i++) {
				arr[i] = sc.nextInt();//하이픈 위치 입력
			}
			Arrays.sort(arr);
			
			for(int i=0;i<h;i++) {
				str.add(arr[i]+i, "-");
			}
			
			sb.append("#"+test_case+" ");
			for(int i=0;i<str.size();i++) {
				sb.append(str.get(i));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
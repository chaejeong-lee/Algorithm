import java.awt.Checkbox;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			String s = sc.next();
			String[] arr = new String[s.length()/3];
			for(int i=0;i<s.length();i+=3) {
				arr[i/3] = s.substring(i, i+3);
			}
			boolean ch = check(arr);
			
			if(!ch) sb.append("#"+test_case+" ERROR\n");
			else {
				int[] cnt = minusch(arr);
				sb.append("#"+test_case+" ");
				for(int i=0;i<cnt.length;i++) {
					sb.append(cnt[i]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	
	//카드 중복 체크
	private static boolean check(String[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i].equals(arr[j])) {
					return false;
				}
			}
		}
		return true;
	}
	//포함된 알파벳 확인
	private static int[] minusch(String[] arr) {
		int[] cnt = {13, 13, 13, 13};//s, d, h, c
		for(int i=0; i<arr.length;i++) {
			if(arr[i].contains("S")){
				cnt[0]--;
			}else if(arr[i].contains("D")) {
				cnt[1]--;
			}else if(arr[i].contains("H")) {
				cnt[2]--;
			}else if(arr[i].contains("C")) {
				cnt[3]--;
			}
		}
		return cnt;
	}
}
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			int N = sc.nextInt();
			
			String str = "";
			for(int i=0;i<N;i++) {
				str += sc.next();
			}
			
			//i의 값을 string으로 변환 후, 위에서 이어붙인 str에 포함되지 않을 경우 -> 가장 작은 정수
			for(int i=0;;i++) {
				if(!str.contains(Integer.toString(i))) {
					sb.append("#"+test_case+" "+i+"\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}
	
}
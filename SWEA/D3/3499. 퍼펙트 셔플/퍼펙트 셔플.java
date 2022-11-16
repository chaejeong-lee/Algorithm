import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int N = sc.nextInt();
			String[] arr = new String[N];
			
			for(int i=0;i<N;i++) {
				arr[i]=sc.next(); 
			}
			

			boolean check = false;
			if(N%2==1) {
				N = N/2+1;
				check = true;
			}
			else N = N/2;
			
			sb.append("#"+test_case+" ");
			for(int i=0;i<N;i++) {
				if(check&&i==(N-1)) {
					sb.append(arr[i]);
				}else {
					sb.append(arr[i]+" "+arr[i+N]+" ");
				}
				
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
}
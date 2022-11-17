import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			
			int answer = 0;
			
			for(int i=1;i<n;i++) {
				if(arr[i]==0) continue;
				int day = arr[i]-1;
				answer+=1;
				for(int j=1;j<n;j++) {
					if((arr[j]-1)%day==0) {
						arr[j]=0;
					}
				}
			}
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.print(sb);
	}
}
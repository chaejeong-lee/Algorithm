import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			int[] lis = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			
			int cnt=0;
			lis[cnt++]=arr[0];//첫번째 깞 넣어주기
			
			for(int i=1;i<N;i++) {
				if(lis[cnt-1]<arr[i]) {
					lis[cnt++] = arr[i];
				}else {
					lis[lowerBound(lis, arr[i], 0, cnt)]=arr[i];
				}
			}
			int answer=0;
			for(int i=0; i<arr.length;i++) {
				if(lis[i]!=0) answer++;
			}
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.print(sb);
	}
	
	private static int lowerBound(int[] lis, int v, int s, int e) {
		while(s<e) {
			int mid = s+(e-s)/2;
			if(v<=lis[mid]) {
				e=mid;
			}else {
				s=mid+1;
			}
		}
		return s;
	}
}
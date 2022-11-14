import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			int sum = 0;
			if (N == 1) {
				sum = arr[0][0];
			} else {
				int mid = N / 2;
				// 상단 삼각형
				for (int i = 0; i < mid; i++) {
					for (int j = mid - i; j <= mid + i; j++) {
						sum += arr[i][j];
					}
				}
				
				//하단 삼각형
				for(int i=mid;i>=0;i--) {
					for(int j=j=mid-i;j<=mid+i;j++) {
						sum += arr[N-i-1][j];
					}
				}
			}
			sb.append("#"+test_case+" "+sum+"\n");

		}
		System.out.println(sb);
	}
}
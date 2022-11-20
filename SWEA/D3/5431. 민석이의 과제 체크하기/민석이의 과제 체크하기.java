import java.util.*;

public class Solution {
	static int num_size=7;
	static int SIZE=3;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();//수강생의 수
			int K = sc.nextInt();//과제를 제출한 사람의 수
			int[] arr = new int[K];
			for(int i=0;i<K;i++) {
				arr[i]=sc.nextInt();
			}
			Arrays.sort(arr);
			int cnt=0;
			sb.append("#"+test_case+" ");
			for(int i=1;i<=N;i++) {
				if(cnt<K&&(i==arr[cnt])) {
					cnt++;
					continue;
				}
				sb.append(i+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
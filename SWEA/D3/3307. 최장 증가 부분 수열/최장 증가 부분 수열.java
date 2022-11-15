import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int[] arr = new int[N];
			int[] lis = new int[N];//동적 배열 : 각원소를 마지막에 끼워넣었을 때 최장 증가 길이 구하기
            
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int max=0;

            for(int i=0;i<N;i++) {
				lis[i]=1;//혼자 있는 수열 -> 최장 길이 : 1
				for(int j=0;j<i;j++) {//i번째 원소보다 작은 j에 대해 
					if(arr[i]>arr[j]&&lis[j]+1>lis[i] )//i번째 원소가 j번째 원소보다 커야 끼워넣을 수 있다. && j번째 원소 길이+1가 현재 최장 길이보다 크면 갱신
						lis[i]=lis[j]+1; 
				}
				if(max<lis[i]) max=lis[i];
			}
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.print(sb);

	}

}
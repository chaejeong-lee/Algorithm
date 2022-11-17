import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			int n = sc.nextInt();//n개의 과목에 대한 시험을 쳤음
			int k = sc.nextInt();//성적표에는 k개으 ㅣ과목을 선택하여 넣을 수 있음
			
			int[] arr = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			int sum=0;
			for(int i=arr.length-1;i>arr.length-k-1;i--) {
				sum += arr[i];
			}
			sb.append("#"+test_case+" "+sum+"\n");
		}
		System.out.print(sb);
	}
}
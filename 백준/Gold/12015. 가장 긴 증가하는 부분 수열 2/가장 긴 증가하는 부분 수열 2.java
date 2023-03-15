import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr =  new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		int len = 1;
		for(int i=1;i<N;i++) {
			int key = arr[i];
			if(dp[len-1]<key) {//키 값이 dp 배열의 마지막 값보다 클 경우 추가해주기
				len++;
				dp[len-1] = key;
			}else {
				int low= 0;
				int high = len;
				while(low<high) {
					int mid = (low+high)/2;
					if(dp[mid]>=key) {
						high = mid;
					}else {
						low = mid +1;
					}
				}
				dp[low] = key;
			}
		}
		System.out.println(len);
	}
}
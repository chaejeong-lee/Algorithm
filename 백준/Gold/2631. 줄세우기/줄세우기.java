import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		int max = 0;
		
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(numbers[j] < numbers[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = max < dp[i]? dp[i]:max;
		}
		System.out.println(N-max);
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int playNum = 18;
	static double[][][] dp = new double[playNum+1][playNum+1][playNum+1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double A = Integer.parseInt(br.readLine());
		double B = Integer.parseInt(br.readLine());
		A /= 100;
		B /= 100;
		
		setPlay(A, B);
		
		double answer = 0;
		
		for(int i=0;i<=playNum;i++) {
			for(int j=0;j<=playNum;j++) {
				if(isPrime(i) || isPrime(j)) answer += dp[playNum][i][j];
			}
		}
		System.out.println(answer);
	}

	private static void setPlay(double A, double B) {
		dp[0][0][0] = 1;
		
		for(int i=1;i<=playNum;i++) {
			for(int j=0;j<=i;j++) {
				for(int k=0;k<=i;k++) {
					// a만 득점
					if(j>0) dp[i][j][k] += dp[i-1][j-1][k] * A * (1-B);
					// b만 득점
					if(k>0) dp[i][j][k] += dp[i-1][j][k-1] * (1-A) * B;
					// 둘다 득점
					if(j>0 && k>0) dp[i][j][k] += dp[i-1][j-1][k-1] * A*B;
					// 둘다 실패
					dp[i][j][k] += dp[i-1][j][k] * (1-A) * (1-B);
				}
			}
		}
	}
	
	private static boolean isPrime(int num) {
		if(num < 2) return false;
		
		for(int i=2;i*i <=num;i++) {
			if(num%i==0) return false;
		}
		
		return true;
	}
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		
		// 누적합 알파벳 계산하기
		int[][] alphaPrefixSum = new int[S.length()+1][26];
		for(int i=1; i<=S.length();i++) {
			int cur = S.charAt(i-1) - 'a';
			for(int j=0;j<26;j++) {
				int beforeCnt = alphaPrefixSum[i-1][j];
				
				alphaPrefixSum[i][j] = (j == cur ? beforeCnt + 1: beforeCnt);
			}
		}
		
		// 테스트케이스 시작
		int tc = Integer.parseInt(br.readLine());
		for(int T = 0; T < tc;T++) {
			st = new StringTokenizer(br.readLine());
			int alp = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken())+1;
			int end = Integer.parseInt(st.nextToken())+1;
			
			sb.append(alphaPrefixSum[end][alp] - alphaPrefixSum[start-1][alp]).append("\n");
		}
		System.out.print(sb);
	}

}
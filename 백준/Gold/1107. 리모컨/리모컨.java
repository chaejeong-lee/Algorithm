import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		boolean[] brokenButtons = new boolean[10];
		
		if(M != 0) {
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<M;i++) {
				int idx = Integer.parseInt(st.nextToken());
				brokenButtons[idx] = true;
			}
		}
		
		int answer = Math.abs(N - 100);//초기 채널
		
		for(int i=0;i<=999999;i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean isBreak = false;
			for(int j=0;j<len;j++) {
				if(brokenButtons[str.charAt(j)-'0']) {
					isBreak = true;
					break;
				}
			}
			
			if(!isBreak) {
				int min = Math.abs(N-i)+len;
				answer = Math.min(min, answer);
			}
		}
		
		System.out.println(answer);
	}

}
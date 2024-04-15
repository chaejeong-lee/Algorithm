import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] numbers = new int[N];
			char[] bombs = new char[N];
			
			String str = br.readLine();
			for(int i=0;i<N;i++) {
				numbers[i] = str.charAt(i)-'0';
			}
			
			str = br.readLine();
			for(int i=0;i<N;i++) {
				bombs[i] = str.charAt(i);
			}
			
			int answer = 0;
			for(int j=0;j<N;j++) {
				if(j==0) {
					if(numbers[j] != 0 && numbers[j+1] != 0) {
						numbers[j]--;
						numbers[j+1]--;
						answer++;
					}
				}
				else if(j==N-1) {
					if(numbers[j-1] != 0 &&numbers[j] != 0) {
						numbers[j-1]--;
						numbers[j]--;
						answer++;
					}
				}
				else {
					if(numbers[j-1]!=0 && numbers[j]!=0 && numbers[j+1]!=0) {
						numbers[j-1]--;
						numbers[j]--;
						numbers[j+1]--;
						answer++;
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}
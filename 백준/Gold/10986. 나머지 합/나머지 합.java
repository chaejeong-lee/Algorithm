import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long answer = 0;
		long[] arr = new long[N+1];
		long[] cnt = new long[M];// 같은 나머지의 인덱스 카운트
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			arr[i] = (arr[i-1]+Integer.parseInt(st.nextToken()))%M;
			if(arr[i] == 0) answer++;
			cnt[(int)arr[i]]++;
		}
		
		for(int i=0;i<M;i++) {
			if(cnt[i]>1) answer += (cnt[i] * (cnt[i]-1)/2);
		}
		System.out.println(answer);
	}

}
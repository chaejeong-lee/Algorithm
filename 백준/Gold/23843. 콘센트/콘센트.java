import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());	// 전자기기 개수
		int M = Integer.parseInt(st.nextToken());	// 콘센트 개수
		
		Long[] times = new Long[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) times[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(times, Collections.reverseOrder());
		
		PriorityQueue<Long> pq = new PriorityQueue<>(); 
		
		long result = 0;
		if(N>M) {
			for(int i=0;i<M;i++) pq.add(times[i]);
			
			for(int i=M;i<N;i++) {
				long next = pq.poll() + times[i];
				pq.add(next);
			}
			
			for(int i=0;i<M;i++) {
				result = pq.poll();
			}
		}
		else {
			result = times[0];
		}
		
		System.out.println(result);
	}
}

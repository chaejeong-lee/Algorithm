import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			int K = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for(int i=0;i<K;i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			long sum = 0;
			
			while(pq.size()>1) {
				Long a = pq.poll();
				Long b = pq.poll();
				
				sum += (a+b);
				
				pq.add(a+b);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
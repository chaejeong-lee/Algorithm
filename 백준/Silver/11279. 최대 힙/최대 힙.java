import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//내림차순
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			//x가 0일때 비어있으면 0, 비어있지 않으면 맨 앞에 위치한 값을 제거, 출력
			if(x == 0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
	}

}
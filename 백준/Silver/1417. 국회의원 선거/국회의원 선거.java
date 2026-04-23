import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 및 pq 삽입
		int N = Integer.parseInt(br.readLine()) - 1;
		int dasom = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int count = 0;
		while (!pq.isEmpty() && pq.peek() >= dasom) {		
			++dasom;
			pq.add(pq.poll() - 1);
			++count;
		}

		System.out.println(count);
	}
}

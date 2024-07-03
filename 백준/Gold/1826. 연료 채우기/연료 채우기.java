import java.io.*;
import java.util.*;

public class Main {

	private static class Info implements Comparable<Info> {
		int dis, fuel;
		
		public Info(int dis, int fuel) {
			this.dis = dis;
			this.fuel = fuel;
		}
		
		@Override
		public int compareTo(Info o) {
			return this.dis - o.dis;
		}
	}
	
	private static int N, L, P;
	private static PriorityQueue<Info> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			pq.add(new Info(a, b));
		}

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		PriorityQueue<Integer> pqFuel = new PriorityQueue<>(Collections.reverseOrder());
		while(P < L) {
			while(!pq.isEmpty() && pq.peek().dis <= P) {
				pqFuel.add(pq.poll().fuel);
			}
			
			if(pqFuel.isEmpty()) {
				answer = -1;
				break;
			}
			
			P += pqFuel.poll();
			answer++;
		}
		
		System.out.println(answer);
	}

}
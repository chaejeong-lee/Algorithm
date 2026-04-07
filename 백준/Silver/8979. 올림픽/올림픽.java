import java.io.*;
import java.util.*;

public class Main {
	
	static class Medal implements Comparable<Medal> {
		int idx, gold, silver, cooper;
		
		public Medal(int idx, int gold, int silver, int cooper) {
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.cooper = cooper;
		}

		@Override
		public int compareTo(Medal o) {
			if(o.gold == this.gold) {
				if(o.silver == this.silver) {
					return o.cooper - this.cooper;
				}
				return o.silver - this.silver;
			}
			return o.gold - this.gold;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Medal> countries = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int cooper = Integer.parseInt(st.nextToken());
			countries.add(new Medal(idx, gold, silver, cooper));
		}
		
		int rank = 1;
		int diff = 1;
		
		while(!countries.isEmpty()) {
			Medal cur = countries.poll();
			Medal next = countries.peek();
			
			if(cur.idx == K) break;
			
			if(cur.gold == next.gold && cur.silver == next.silver && cur.cooper == cur.cooper) {
				diff++;
			}
			else {
				rank += diff;
				diff = 1;
			}
		}
		System.out.println(rank);
	}

}

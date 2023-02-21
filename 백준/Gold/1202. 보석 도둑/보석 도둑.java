import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Jewel{
		int M, V;//M : 무게, V : 가격

		public Jewel(int M, int V) {
			this.M = M;
			this.V = V;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewel[] jewels = new Jewel[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			jewels[i]= new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
		}
		
		Arrays.sort(jewels, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				if(o1.M == o2.M) {
					return o2.V - o1.V;
				}
				return o1.M - o2.M;
			}
		});
		
		int[] C = new int[K];
		for(int i=0;i<K;i++) {
			C[i]= Integer.parseInt(br.readLine()); 
		}
		
		Arrays.sort(C);
		
		//가격이 내림차순이 되도록..
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		long sum = 0;
		
		for(int i=0, j=0;i<K;i++) {
			while(j<N && jewels[j].M <= C[i])
				pq.offer(jewels[j++].V);
			
			if(!pq.isEmpty())//내림차순 되어 있으므로 첫번째 요소가 가장 큰 값이 들어오고 비어질 때까지 들어간다.
				sum += pq.poll();
		}
		System.out.println(sum);
	}
}
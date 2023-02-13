import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] greenOnion = new int[S];

		long sum = 0;
		for (int i = 0; i < S; i++) {
			greenOnion[i] = Integer.parseInt(br.readLine());
			sum += greenOnion[i];
		}

		int start = 1;
		int end = 1000000000;

		while (start <= end) {
			int mid = (start+end)/2;
			
			int cnt = 0;
			for(int i=0;i<S;i++) {
				cnt += greenOnion[i]/mid;
			}
			
			if(cnt>= C)
				start = mid +1;
			else
				end = mid -1;
		}
		System.out.println(sum - end*(long)C);
	}

}

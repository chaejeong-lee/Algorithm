import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> gift = new PriorityQueue<>((o1, o2)-> o2-o1);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 0 ) {
				if(gift.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(gift.poll()).append("\n");
				}
			}else {
				for(int j=0;j<a;j++) {
					gift.add(Integer.parseInt(st.nextToken()));
				}
			}
			
		}
		System.out.println(sb);
	}
}
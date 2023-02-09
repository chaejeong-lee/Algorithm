import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		card();
	}

	private static void card() {
		if(q.size()==1) {
			System.out.println(q.poll());
			return;
		}
		q.poll();
		int num = q.poll();
		q.offer(num);
		
		card();
	}
}
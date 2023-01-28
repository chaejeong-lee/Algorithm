import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		long num = 0;
		
		//들어가있는 개수가 2개 이상이어야 비교 가능함
		while(pq.size()>1) {
			long tmp1 = pq.poll();
			long tmp2 = pq.poll();
			
			num += tmp1 + tmp2;
			pq.add(tmp1+tmp2);//마지막 값을 다시 넣어줘야 다시 빼냈을 때 이 합한 값이랑 그 다음 값을 더해주기 때문에
		}
		System.out.println(num);
		
	}

}

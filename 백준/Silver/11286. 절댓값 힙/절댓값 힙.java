import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		//우선순위 큐를 통해 우선순위를 정해서 출력하도록 한다
		//우선순위 큐를 통해 
		//절대값이 같은 경우 - 그대로 비교
		//절대값이 다른 경우 - 두 수 모두 절대값을 씌워 비교하여 우선순위를 주도록 하였다. 
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->
			Math.abs(o1) == Math.abs(o2)? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))//compare : -1(앞이 작음), 0(같음), 1(앞이 큼)
		);
		
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());//연산에 대한 정보를 나타내는 정수 x
			
			if(x == 0) {
				if(!pq.isEmpty()) {//배열에서 절대값이 가장 작은 값을 출력 -> 그 값을 제거
					sb.append(pq.poll()).append("\n");
				}else {//배열이 비어있는 경우 0을 출력
					sb.append("0\n");
				}
			}
			else {// x가 0이 아니라면 배열에 x라는 값을 추가
				pq.add(x);
			}
		}
		System.out.print(sb);
	}

}
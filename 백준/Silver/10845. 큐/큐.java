import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		int num = 0;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch (s) {
			case "push":
				//정수 X를 큐에 넣는 연산
				num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				break;
			case "pop":
				//큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.poll()).append("\n");
				break;
			case "size":
				//큐에 들어있는 정수의 개수를 출력
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				//큐가 비어있으면 1, 아니면 0을 출력
				if(queue.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "front":
				//큐의 가장 앞에 있는 정수를 출력 -> 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.peek()).append("\n");
				break;
			case "back":
				//큐의 가장 뒤에 있는 정수를 출력 -> 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(num).append("\n");
				break;
			}
		}
		System.out.print(sb);
	}

}
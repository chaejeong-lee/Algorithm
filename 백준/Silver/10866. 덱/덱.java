import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String check = st.nextToken();
			
			int num = 0;
			
			switch (check) {
			case "push_front"://정수 X를 덱의 앞에 넣는다
				num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
				break;
			case "push_back"://정수 X를 덱의 뒤에 넣는다.
				num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
				break;
			case "pop_front"://덱의 가장 앞에 있는 수를 빼고 그 수를 출력. 만약 덱에 들어있는 정수가 없는 경우 -1을 출력
				if(deque.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deque.pollFirst()+"\n");
				}
				break;
			case "pop_back"://덱의 가장 뒤에 있는 수를 빼고 그 수를 출력. 만약 덱에 들어있는 정수가 없는 경우 -1을 출력
				if(deque.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deque.pollLast()+"\n");
				}
				break;
			case "size"://덱에 들어있는 정수의 개수를 출력
				sb.append(deque.size()+"\n");
				break;
			case "empty"://덱이 비어있으면 1을 아니면 0을 출력
				if(deque.isEmpty()) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
			case "front"://덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1 출력
				if(deque.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deque.peekFirst()+"\n");
				}
				break;
			case "back"://덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1 출력
				if(deque.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deque.peekLast()+"\n");
				}
				break;
			}
		}
		System.out.print(sb);
	}

}

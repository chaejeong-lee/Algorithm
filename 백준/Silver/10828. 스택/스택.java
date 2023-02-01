import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String check = st.nextToken();
			switch (check) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stack.isEmpty())
					sb.append("-1\n");
				else 
					sb.append(stack.pop()+"\n");
				break;
			case "size":
				sb.append(stack.size()+"\n");
				break;
			case "empty":
				if(stack.isEmpty())
					sb.append("1\n");
				else {
					sb.append("0\n");
				}
				break;
			case "top":
				if(stack.isEmpty())
					sb.append("-1\n");
				else sb.append(stack.peek()+"\n");
				break;
			}
		}
		System.out.println(sb);
	}

}

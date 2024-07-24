import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static Stack<Integer> st;
	static long answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new Stack<>();
		
		for(int i=0;i<N;i++) {
			int height = Integer.parseInt(br.readLine());
			while(!st.isEmpty()) {
				if(st.peek()<= height) {
					st.pop();
				}
				else {
					break;
				}
			}
			answer += st.size();
			st.push(height);
		}
		System.out.println(answer);
	}

}
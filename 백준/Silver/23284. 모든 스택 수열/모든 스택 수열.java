import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int N;
	static int[] stack;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		stack = new int[N+1];
		check = new boolean[N+1];

		popNum(0, 1);
		System.out.print(sb);
	}

	private static void popNum(int cnt, int next) {
		if (cnt == N) {
			for (int i=0;i<N;i++)
				sb.append(stack[i] + " ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (check[i])
				continue;
			if (cnt != 0 && stack[cnt - 1] < i && i < next)
				break;

			check[i] = true;
			stack[cnt] = i;
			popNum(cnt + 1, Math.max(next, i));
			stack[cnt] = 0;
			check[i]= false; 
		}
	}
}

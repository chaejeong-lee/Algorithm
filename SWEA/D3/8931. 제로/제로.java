import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
			Stack<Integer> arr = new Stack<>();

			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if (num == 0) {
					arr.pop();
				} else {
					arr.push(num);
				}
			}
			int sum = 0;
			while(!arr.isEmpty()) {
				sum += arr.pop();
			}
			sb.append("#" + test_case + " " + sum + "\n");
		}

		System.out.print(sb);
	}

}
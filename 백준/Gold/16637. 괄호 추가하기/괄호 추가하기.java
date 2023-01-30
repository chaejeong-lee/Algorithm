import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static ArrayList<Character> opers;
	static ArrayList<Integer> nums;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();

		opers = new ArrayList<>();
		nums = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				opers.add(c);
				continue;
			}
			nums.add(Character.getNumericValue(c));
		}

		answer = Integer.MIN_VALUE;
		DFS(nums.get(0), 0);
		
		bw.write(answer+"\n");

		bw.flush();
		bw.close();
		br.close();

	}

	public static int calc(char oper, int n1, int n2) {
		switch (oper) {
		case '+':
			return n1 + n2;
		case '*':
			return n1 * n2;
		case '-':
			return n1 - n2;
		}
		return -1;
	}

	public static void DFS(int result, int opIdx) {
		if (opIdx >= opers.size()) {//주어진 연산자의 개수를 초과하였을 경우
			answer = Math.max(answer, result);
			return;
		}

		//괄호가 없는 경우
		int result1 = calc(opers.get(opIdx), result, nums.get(opIdx + 1));
		DFS(result1, opIdx+1);
		
		//괄호가 있는 경우
		if(opIdx +1 <opers.size()) {
			//result의 오른쪽에 있는 값을 연산함
			int result2 = calc(opers.get(opIdx+1), nums.get(opIdx+1), nums.get(opIdx+2));
			//현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
			DFS(calc(opers.get(opIdx), result, result2), opIdx+2);
		}
	}
}
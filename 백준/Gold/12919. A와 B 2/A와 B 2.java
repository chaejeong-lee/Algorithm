import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int answer = 0;
	static String S, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		dfs(T);
		System.out.println(answer);
	}

	private static void dfs(String str) {
		if(str.length() == S.length()) {
			if(str.equals(S)) answer = 1;
			return;
		}
		
		if(str.endsWith("A")) dfs(str.substring(0, str.length()-1));
		if(str.startsWith("B")) {
			StringBuffer sb = new StringBuffer(str.substring(1));
			String reverse = sb.reverse().toString();
			dfs(reverse);
		}
	}
}

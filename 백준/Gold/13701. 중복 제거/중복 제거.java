import java.io.*;
import java.util.*;

public class Main {
	private static final int N = 33554432;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int cnt = st.countTokens();
		
		BitSet bs = new BitSet(N);
		for(int i=0;i<cnt;i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(!bs.get(cur)) {
				bs.set(cur);
				sb.append(cur).append(" ");
			}
		}
		System.out.println(sb);
	}
}

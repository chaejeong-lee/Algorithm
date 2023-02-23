import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int L, C;
	static String[] alpha;
	static String[] passwords;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new String[C];
		passwords = new String[L];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<alpha.length;i++) {
			alpha[i] = st.nextToken();
		}
		
		Arrays.sort(alpha);
		comb(0, 0);
		System.out.print(sb);
	}

	private static void comb(int cnt,int start) {
		if(cnt==L) {
			if(check()) {
				for(String s:passwords) sb.append(s);
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start;i<alpha.length;i++) {
			passwords[cnt]=alpha[i]; 
			comb(cnt+1, i+1);
		}
	}
	
	private static boolean check() {
		int ConsonantsCnt = 0;//자음 개수
		int VowelsCnt = 0;//모음 개수

		for(String s:passwords) {
			if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") ||s.equals("u")) {
				VowelsCnt++;
			}else {
				ConsonantsCnt++;
			}
		}
		if(VowelsCnt>=1 && ConsonantsCnt>=2) {
			return true;
		}else {
			return false;
		}
	}
}

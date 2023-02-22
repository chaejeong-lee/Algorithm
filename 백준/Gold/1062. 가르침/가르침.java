import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int max;
	static String[] words;
	static boolean[] visited;
	static char[] contains = {'a', 'n', 't', 'i', 'c'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//단어 N개
		K = Integer.parseInt(st.nextToken());//K개의 글자(알파벳 26자)
		
		words = new String[N];
		visited = new boolean[26];
		
		max = Integer.MIN_VALUE;
		
		//남극 언어에 존재하는 단어
		for(int i=0;i<N;i++) {
			words[i] = br.readLine();
			words[i] = words[i].replace("anta", "");
			words[i] = words[i].replace("tica", "");
		}
		
		if(K==26) {//알파벳을 모두 배운 경우 해당 단어를 모두 말할 수 있다. 
			max = N;
		}
		else if(K>=5) {//알파벳이 5개 이상이어야 최소 말을 할 수 있다. 
			for(int i=0;i<contains.length;i++) {
				visited[contains[i]-'a'] = true;
			}
			backtracking(0, 0);
		}else if(K<5){
			max = 0;
		}
		
		System.out.println(max);
	}

	private static void backtracking(int start, int len) {
		if(len ==(K-contains.length)) {
			int cnt = 0;
			for(int i=0;i<words.length;i++) {
				boolean check = true; 
				for(int j=0;j<words[i].length();j++) {
					if(!visited[words[i].charAt(j)-'a']) {
						check = false;
						break;
					}
				}
				if(check) cnt++;
			}
			max = Math.max(cnt, max);
		}
		
		for(int i = start; i<visited.length;i++) {
			if(!visited[i]) {
				visited[i]= true;
				backtracking(i, len+1);
				visited[i]= false; 
			}
		}
	}
}

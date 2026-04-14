import java.io.*;
import java.util.*;

public class Main {
	
	static class Score implements Comparable<Score> {
		int documentScore, interviewScore;
		
		public Score(int documentScore, int interviewScore) {
			this.documentScore = documentScore;
			this.interviewScore = interviewScore;
		}
		
		@Override
		public int compareTo(Score s) {
			if(this.documentScore == s.documentScore) {
				return this.interviewScore - s.interviewScore;
			}
			return this.documentScore - s.documentScore;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) {

			ArrayList<Score> list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				
				int documentScore = Integer.parseInt(st.nextToken());
				int interviewScore = Integer.parseInt(st.nextToken());
				
				list.add(new Score(documentScore, interviewScore));
			}
			
			Collections.sort(list);
			
			int answer = 1;
			int min = list.get(0).interviewScore;
			
			for(int i=1;i<N;i++) {
				if(list.get(i).interviewScore < min) {
					answer++;
					min = list.get(i).interviewScore;
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}

}
import java.io.*;
import java.util.*;

public class Main {
	
	private static final int INF = Integer.MAX_VALUE/2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int membersCnt = Integer.parseInt(br.readLine());
		int[][] members = new int[membersCnt+1][membersCnt+1];
		
		for(int i=0;i<=membersCnt;i++) {
			for(int j=0;j<=membersCnt;j++) {
				if(i != j) members[i][j] = INF;
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			
			if(friend1 == -1 && friend2 == -1) break;
			
			members[friend1][friend2] = members[friend2][friend1] = 1;
		}
		
		//플로이드 와샬 알고리즘 수행 -> 주어진 일부분의 친구 관계를 가지고 모든 사람들의 친구 관계로 확장시켜야 하므로!
		// 노드 1개부터 membersCnt까지 거쳐가는 모든 경우를 고려
		for(int k=1;k<=membersCnt;k++) {
			for(int i=1;i<=membersCnt;i++) {
				// i에서 j로 가는 경우
				for(int j=1;j<=membersCnt;j++) {
					members[i][j] = Math.min(members[i][j], members[i][k]+members[k][j]);
				}
			}
		}
		
		//회장 후보 점수
		int leaderScore = INF;
		// 친구 점수 목록
		int[] friendScore = new int[membersCnt+1];
		
		for(int i=1;i<=membersCnt;i++) {
			int score = 0;
			for(int j=1;j<=membersCnt;j++) {
				if(members[i][j] != INF) 
					score = Math.max(score, members[i][j]);
			}
			friendScore[i] = score;
			leaderScore = Math.min(leaderScore, score);// 회장은 회원들 중에서 점수가 가장 작은 사람이 되기 때문에 max가 아니라 min
		}		
		
		// 회장 후보 점수와 동일 사람 수
		int leaderCnt = 0;
		
		// 친구 점수 목록 중 최대값과 동일한 값 찾기
		// 친구 점수 목록 출력할 StringBuilder 새로 선언
		StringBuilder sb2 = new StringBuilder();
		for(int i=1;i<=membersCnt;i++){
			if(friendScore[i] == leaderScore) {
				leaderCnt++;
				sb2.append(i).append(" ");
			}
		}

		sb.append(leaderScore).append(" ").append(leaderCnt);
		System.out.println(sb);
		System.out.print(sb2);
	}

}
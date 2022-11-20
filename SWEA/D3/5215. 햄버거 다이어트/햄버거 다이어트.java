import java.util.*;

public class Solution {
	static int N, L;//재료의수, 제한 칼로리 수
	static int[] score;//점수
	static int[] cal;
	static int answer;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();//재료의 수
			L = sc.nextInt();//칼로리의 수
			
			score = new int[N];
			cal = new int[N];
			answer=Integer.MIN_VALUE;
			
			for(int i=0;i<N;i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			hamburger(0, 0, 0);
            sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.print(sb);
	}
	
	private static void hamburger(int idx, int sumt, int sumc) {//idx: 배열의 순서 확인, sumt: 맛 점수의 합, sumc: 칼로리 합
		if(sumc>L) {//제한된 칼로리 수보다 넘쳤을 경우
			return;
		}
		if(sumc<=L) {
			answer = Math.max(answer, sumt);
		}
		if(idx==N) {//N번째까지 확인했을 때
			return;
		}
		
		hamburger(idx+1,sumt+score[idx], sumc+cal[idx]);//이 재료를 사용해보자
		hamburger(idx+1, sumt, sumc);//이 재료는 사용하지 않을 것이다.
	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int L;
	private static int effectiveRange, killingPower; // 유효사거리, 살상력
	private static int landMind; // 지뢰
	private static int[] zombieHealth;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		L = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		effectiveRange = Integer.parseInt(st.nextToken());
		killingPower = Integer.parseInt(st.nextToken());
		
		landMind = Integer.parseInt(br.readLine());
		
		zombieHealth = new int[L+1];
		for(int i=1;i<=L;i++) {
			zombieHealth[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solution());
		
	}

	private static String solution() {
		Queue<Integer> q = new LinkedList<>();
		int skip = 0;
		
		for(int i=1;i<=L;i++) {
			int distance = Math.min(i, effectiveRange)-skip;
			
			if(zombieHealth[i] > distance * killingPower) {
				// 폭탄의 개수가 하나도 없으면 죽는다.
				if(landMind == 0) return "NO";
				// 폭탄을 사용한 경우
				landMind--;
				skip++;
				q.add(i);
			}
			
			if(q.isEmpty()) continue;
			
			if(i-q.peek() == effectiveRange) {
				q.poll();
				skip--;
			}
		}
		
		return "YES";
	}
}
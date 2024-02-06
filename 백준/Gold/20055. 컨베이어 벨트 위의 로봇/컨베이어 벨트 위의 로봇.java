import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] arr;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N*2];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N*2;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(simulation());
	}

	private static int simulation() {
		int cnt = 0;
		
		while(isPossible()) {
			// 로봇과 함께 한칸 회전
			int tmp = arr[N*2-1];
			for(int i=N*2-1;i>0;i--) {
				arr[i] = arr[i-1];
			}
			arr[0] = tmp;
			
			for(int i = N-1;i>0;i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false;
			robot[N-1] = false;
			
			// 로봇 한칸 이동
			for(int i=N-1;i>0;i--) {
				if(robot[i-1] && !robot[i] && arr[i]>0) {
					arr[i]--;
					robot[i] = true;
					robot[i-1] = false;
				}
			}
			
			
			// 올리는 칸 위치에 내구도가 0이 X -> 로봇 올리기
			if(arr[0]>0) {
				robot[0] = true;
				arr[0]--;
			}
			cnt++;
		}
		
		return cnt;
	}
	
	private static boolean isPossible() {
		int cnt = 0;
		for(int i=0;i<N*2;i++) {
			if(arr[i]==0) cnt++;
			if(cnt>=K) return false;
		}
		return true;
	}
}
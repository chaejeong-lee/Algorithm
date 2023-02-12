import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int N;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		
		popNum(0, 0);
	}

	private static void popNum(int cnt, int start) {
		if(cnt == N) {
			for(int i=0;i<N;i++)
				System.out.print(numbers[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			boolean duplication = true;//중복인지 확인
			numbers[cnt] = i;//현재 자리 수 지정
			
			for(int j= 0;j<cnt;j++) {
				if(numbers[j]== numbers[cnt]) duplication = false; //중복 확인
			}
			
			if(duplication) {
				//직전 수보다 현재 들어온 수가 크고 다음 넣을 수 보다 현재 들어온 수가 작다면 잘못된 수열이므로 break
				if(cnt!=0 && numbers[cnt-1]<numbers[cnt] && numbers[cnt]<start)
					break;
			}
			if(duplication) {
				if(start<=numbers[cnt])//현재 들어온 수가 새로운 수라면 next에 +1을 해주어야 함
					popNum(cnt+1, numbers[cnt]+1);
				else//현재 들어온 수가 이미 들어온 수를 꺼낸 것이라면 값(start)은 유지
					popNum(cnt+1, start);
				
			}
		}
	}
}

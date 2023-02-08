import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());//N자릿 수
		dfs(0, "");
		System.out.print(sb);
	}
	
	private static void dfs(int cnt, String str) {
		if(cnt == N) {//자릿수가 맞게 나왔을 경우
			sb.append(str+"\n");
			return;
		}
		
		// 0은 5의 배수가 되므로 굳이 확인할 필요 없음 => 0은 소수 불가능
		for(int i=1;i<=9;i++) {
			if(isPrime(Integer.parseInt(str+i))) {//소수가 맞을 경우 아래 함수 실행
				dfs(cnt+1, str+i);
			}
		}
	}
	
	private static boolean isPrime(int num) {
		//1일 경우 소수가 아님
		if(num==1) return false;
		
		int end = (int)Math.sqrt(num);
		for(int i=2;i<=end;i++) {
			if(num%i==0) return false;
		}
		return true;
		
	}

}

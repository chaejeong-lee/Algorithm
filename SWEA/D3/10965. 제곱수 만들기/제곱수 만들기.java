import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int Max = (int)Math.pow(10, 7)+1;//테스트 상 가장 큰 수
		List<Integer> primeList = new ArrayList<>();//소인수 분해 공식에 활용하기 위한 소수리스트 선언
		boolean[] prime = new boolean[Max];//true-소수, false-소수X
		prime[0]=prime[1]=true;

		//2부터 시작해서 해당 수의 배수를 모두 지워주는 것
		for (int i = 2; i < (int)Math.sqrt(Max); i++) {
			if (!prime[i]) {
				primeList.add(i);
				for (int j = i * i; j < Max; j += i)//i*i 미만은 이미 처리되었으므로, j의 시작값은 i*i로 최적화 가능
					prime[j]=true;
			}
		}
		
		//최대수까지 구한 소수 전체를 제곱하여 squ 리스트에 저장
		List<Integer> squ = new ArrayList<>();
		for(int i:primeList) squ.add(i*i);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int A = sc.nextInt();
			
			//소수의 제곱수를 이용하여 소인수 분해 하기
			for(int div:squ) {
				if(div>A) break;//div의 제곱이 입력수보다 크면 반복 종료
				while(true) {
					if(A%div==0) A/=div;//제곱수로 나눴을 때 딱 떨어지면 나누기
					else 
						break;//나머지가 생기면 다른 제곱수로 나누기 시작
				}
			}
			sb.append("#"+test_case+" "+A+"\n");
		}
		System.out.println(sb);
	}
}
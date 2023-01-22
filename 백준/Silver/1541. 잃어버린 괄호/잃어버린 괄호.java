import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split("-");//-를 기준으로 쪼개고 나중에 다 빼버리는 방식을 위해 그 기준으로 나눔
		
		int sum = Integer.MAX_VALUE;//초기 상태 여부 확인 값
		
		for(int i=0;i<arr.length;i++) {
			int tmp = 0;
			
			//주의할 점 : split의 경우 정규식(regex)을 받기 때문에 '+'을 하면 regex.PatternSyntaxException을 뱉음
			//			+ 문자가 메타문자이기 때문(=특별한 의미를 담고 있음)
			//			그렇기 때문에 온전하게 문자 그 자체로 이용하기 위해서는 이스케이프를 처리해야한다.
			//			\도 단독으로 출력할 수 없기 때문에 백슬래시 자체도 이스케이프 해야함 => \\
			//=> 이 경우 \\+를 해야 우리가 분리하고자 하는 '+' 문자 그대로 분리할 수 있다.
			String[] add = arr[i].split("\\+");
			
			//덧셈으로 나뉜 토큰을 모두 더해줌
			for(int j=0;j<add.length;j++) {
				tmp += Integer.parseInt(add[j]);
			}
			
			//첫번째 계산인지 확인 후 맞을 경우 sum 값에 그대로 대입
			if(sum == Integer.MAX_VALUE) {
				sum = tmp;
			}else {//그 이후로는 초반에 -를 상태로 split 했기 때문에 그것을 기반으로 모두 빼준다. 
				sum -= tmp;
			}
		}
		
		System.out.println(sum);
	}

}
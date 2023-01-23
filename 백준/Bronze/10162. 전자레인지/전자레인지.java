import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//시간 초 출력
		StringBuilder sb = new StringBuilder();
		if(T%10 != 0) {
			sb.append("-1");
		}else {
			int A = T/300;//300으로 나누어 지는지
			int B = (T-A*300)/60;
			int C = (T - A*300 - B*60)/10;
			sb.append(A+" "+B+" "+C);
		}
		System.out.println(sb);
	}

}

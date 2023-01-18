import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();// 개수
		int M = sc.nextInt();// 합을 구해야 하는 횟수
		
		int[] arr = new int[N + 1];
		arr[0] = 0;

		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] + sc.nextInt();
		}

		for (int k = 0; k < M; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();

			sb.append((arr[j] - arr[i - 1]) + "\n");
		}
		System.out.println(sb);
	}

}
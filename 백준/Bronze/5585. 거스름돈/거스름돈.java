import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();

		int cal = 1000 - money;
		int cnt = 0;

		int[] check = { 500, 100, 50, 10, 5, 1 };

		int idx = 0;
		while (cal != 0) {
			cnt += cal / check[idx];
			cal %= check[idx];
			idx++;
		}
		System.out.println(cnt);
	}

}

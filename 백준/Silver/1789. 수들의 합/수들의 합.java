import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long sum = sc.nextLong();
		
		System.out.println(solve(sum));
		
	}

	public static int solve(long n) {
		long sum = 0;
		int addNum = 0;
		while(n>= sum) {
			sum += (++addNum);
		}
		return sum == n?addNum:addNum-1;
	}
}
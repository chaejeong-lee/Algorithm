import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		for(int i = arr.length-1;i>=0;i--) {
			if(K / arr[i]>0) {
				sum += (K/arr[i]);
				K %= arr[i];
			}
		}
		System.out.println(sum);
	}

}

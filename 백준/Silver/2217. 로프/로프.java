import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			max = Math.max(max, arr[i]*(N-i));
		}
		
		System.out.println(max);
	}

}

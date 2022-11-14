import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[100][100];
		for(int i = 0 ; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j = x; j<x+10;j++) {
				for(int k = y; k<y+10;k++) {
					arr[j][k] =1;
				}
			}
		}
		
		int sum = 0;
		for(int i = 0 ; i<arr.length;i++) {
			for(int j = 0 ;j<arr[i].length;j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}

}

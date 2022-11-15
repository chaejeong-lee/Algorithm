import java.util.Scanner;

public class Main {
	
	public static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[M];
		dfs(N, M, 1, 0);
	}

	public static void dfs(int N, int M, int first, int depth) {
		if(depth == M) {
			for(int val:arr) {
				System.out.print(val+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = first ; i <= N ; i++) {
			arr[depth] = i;
			dfs(N, M, i+1, depth+1);
		}
	}
}

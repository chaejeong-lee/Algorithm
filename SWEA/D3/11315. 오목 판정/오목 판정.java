import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	static final int[] dir_Y = {1, 0, 1, 1};
	static final int[] dir_X = {0, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case =1; test_case<=T;test_case++) {
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			
			for(int i = 0; i<N;i++) {
				String s =sc.next();
				for(int j =0; j<N;j++) {
					arr[i][j]=s.charAt(j); 
				}
			}
			String answer = solve(N, arr);
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	static String solve(int N, char[][] arr) {
		for(int i =0; i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]=='o'){
					for(int k = 0 ; k<4;k++) {
						boolean result = check(k, i, j, N, arr);
						if(result) return "YES";
					}
				}
			}
		}
		return "NO";
	}
	
	static boolean check(int dir, int y, int x, int N, char[][] arr) {
		for(int i =0; i<4;i++) {
			y += dir_Y[dir];
			x += dir_X[dir];
			
			if(y<0||x<0||y>=N||x>=N) return false;
			if(arr[y][x] != 'o') return false;
 		}
		return true;
	}
}
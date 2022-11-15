import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		
		int[][] arr = new int[1001][1001];
		
		int num=1;
		for(int i =1; num<=100000;i++) {
			for(int j=1, k=i; j<=i;j++, k--) {
				arr[k][j] =num++; 
			}
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int x1=0, y1=0, x2=0, y2=0;
			boolean check1=false, check2=false;
			for(int i=1; i<arr.length;i++) {
				for(int j=1; j<arr.length;j++) {
					if(check1&&check2) break;
					if(arr[i][j]==p) {
						x1=i;
						y1=j;
						check1=true;
					}
					if(arr[i][j]==q) {
						x2=i;
						y2=j;
						check2=true;
					}
				}
			}
			
			sb.append("#"+test_case+" "+arr[x1+x2][y1+y2]+"\n");
		}
		System.out.print(sb);
	}
}
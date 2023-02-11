import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] paper = new int[101][101];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());//색종이 수
		
		int[][] arr = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			setPaper(arr[i][0], arr[i][1]);
		}
		
		int answer=0;
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				if(paper[i][j]== 1 ) {
					for(int k=0;k<4;k++) {
						if(paper[i+dx[k]][j+dy[k]]==0) answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
	
	private static void setPaper(int x, int y) {
		for(int i=x;i<x+10;i++) {
			for(int j=y;j<y+10;j++) {
				paper[i][j]= 1; 
			}
		}
	}
}

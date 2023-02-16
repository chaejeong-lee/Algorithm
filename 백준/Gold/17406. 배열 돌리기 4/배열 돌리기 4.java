import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, min;
	static int[][] A, A_copy;
	static int[][] rcs;
	static boolean[] visit;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 배열의 크기
		M = Integer.parseInt(st.nextToken());// 배열의 크기
		K = Integer.parseInt(st.nextToken());// 회전 연산의 개수

		A = new int[N][M];
		rcs = new int[K][3];
		visit = new boolean[K];
		result = new int[K];

		for (int i = 0; i < A.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;

		for (int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());
			rcs[t][0] = Integer.parseInt(st.nextToken());
			rcs[t][1] = Integer.parseInt(st.nextToken());
			rcs[t][2] = Integer.parseInt(st.nextToken());
		}

		permutation(0);
		System.out.println(min);
	}

	private static void permutation(int cnt) {
		if (cnt == K) {
			A_copy = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					A_copy[i][j]= A[i][j]; 
				}
			}
			findXY();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[cnt] = i;
				permutation(cnt + 1);
				visit[i] = false;
			}
		}
	}

	private static void findXY() {
		for (int i = 0; i < rcs.length; i++) {
			int sx = rcs[result[i]][0] - rcs[result[i]][2] - 1;
			int sy = rcs[result[i]][1] - rcs[result[i]][2] - 1;
			int lx = rcs[result[i]][0] + rcs[result[i]][2] - 1;
			int ly = rcs[result[i]][1] + rcs[result[i]][2] - 1;
			rotation(sx, sy, lx, ly);
		}
		
		for(int i=0;i<N;i++) {
			int sum = 0;
			for(int j=0;j<M;j++) {
				sum += A_copy[i][j];
			}
			min = Math.min(sum, min);
		}
	}

	private static void rotation(int sx, int sy, int lx, int ly) {
		if (sx == lx && sy == ly)
			return;
		
		int tmp1 = A_copy[sx][ly];
		int tmp2 = A_copy[lx][ly];
		int tmp3 = A_copy[lx][sy];

		//오른쪽 회전
		for (int i = ly; i > sy; i--) {
			A_copy[sx][i]= A_copy[sx][i-1]; 
		}
		
		//아래로 회전
		for(int i=lx;i>sx;i--) {
			if(i==(sx+1)) A_copy[i][ly] = tmp1;
			else A_copy[i][ly] = A_copy[i-1][ly];
		}
		
		for(int i=sy;i<ly;i++) {
			if(i==(ly-1)) A_copy[lx][i]= tmp2;
			else A_copy[lx][i]= A_copy[lx][i+1]; 
		}
		
		for(int i=sx;i<lx;i++) {
			if(i==(lx-1)) A_copy[i][sy] = tmp3;
			else A_copy[i][sy] = A_copy[i+1][sy];
		}
		
		rotation(sx+1, sy+1, lx-1, ly-1);
	}
}

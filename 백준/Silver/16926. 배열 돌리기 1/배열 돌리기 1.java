import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, r;
	static int[][] arr;

	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num = Math.min(n, m) / 2;

		for (int i = 0; i < r; i++) {
			rotation(num);
		}
		printArr();
	}

	private static void rotation(int num) {
		for (int i = 0; i < num; i++) {
			int x = i;
			int y = i;
			int temp = arr[x][y];

			int idx = 0;

			while (idx < 4) {
				int nx = x + dir[idx][0];
				int ny = y + dir[idx][1];

				if (nx >= i && nx < n - i && ny >= i && ny < m - i) {
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				} else {
					idx++;
				}
			}
			arr[i + 1][i] = temp;
		}
	}

	private static void printArr() {
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

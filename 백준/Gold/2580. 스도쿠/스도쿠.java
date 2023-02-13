import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] sudoku = new int[9][9];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 스도쿠 값 받아오기
		for (int i = 0; i < sudoku.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < sudoku[i].length; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
	}

	private static void dfs(int row, int col) {
		if (col == 9) {
			dfs(row + 1, 0);
			return;
		}

		if (row == 9) {
			printSudoku();
			System.exit(0);
		}

		if (sudoku[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (checkSudoku(row, col, i)) {
					sudoku[row][col] = i;
					dfs(row, col + 1);
				}
			}
			sudoku[row][col] = 0;
			return;
		}
		dfs(row, col + 1);
	}

	private static void printSudoku() {
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				sb.append(sudoku[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static boolean checkSudoku(int row, int col, int value) {
		for (int i = 0; i < 9; i++) {//같은 행에 value값과 동일한 원소가 존재하는지 확인
			if (sudoku[row][i] == value) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {//같은 열에 value 값과 동일한 원소가 존재하는지 확인
			if (sudoku[i][col] == value) {
				return false;
			}
		}

		//3X3 배열에 존재하는지 확인
		int indRow = (row / 3) * 3;
		int indCol = (col / 3) * 3;

		for (int i = indRow; i < indRow + 3; i++) {
			for (int j = indCol; j < indCol + 3; j++) {
				if (sudoku[i][j] == value)
					return false;
			}
		}
		return true;
	}
}

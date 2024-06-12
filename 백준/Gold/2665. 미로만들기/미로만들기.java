import java.util.*;
import java.io.*;

public class Main {

	static class Drill {
		int y;
		int x;
		int drill;

		Drill(int y, int x, int drill) {
			this.y = y;
			this.x = x;
			this.drill = drill;
		}
	}

	private static char map[][];
	static int min[][];

	private static int xx[] = { -1, 1, 0, 0 };
	private static int yy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		min = new int[n][n];

		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i] = word.toCharArray();
			}
		}
		bfs();
		System.out.println(min[n - 1][n - 1]);
	}

	public static void bfs() {
		Queue<Drill> queue = new LinkedList<>();

		for (int i = 0; i < min.length; i++)
			Arrays.fill(min[i], 1000000);
		// 1은 흰방 0은 검은 방
		if (map[0][0] == '0') {
			queue.add(new Drill(0, 0, 1));
			min[0][0] = 1;
		} else {
			queue.add(new Drill(0, 0, 0));
			min[0][0] = 0;
		}

		while (!queue.isEmpty()) {
			Drill temp = queue.poll();
			int prevY = temp.y;
			int prevX = temp.x;
			int drill = temp.drill;
			for (int i = 0; i < 4; i++) {
				int nextY = prevY + yy[i];
				int nextX = prevX + xx[i];
				if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map.length)
					continue;
				if (map[nextY][nextX] == '0' && drill + 1 >= min[nextY][nextX])
					continue;
				if (map[nextY][nextX] == '1' && drill >= min[nextY][nextX])
					continue;

				if (map[nextY][nextX] == '1') {
					queue.add(new Drill(nextY, nextX, drill));
					min[nextY][nextX] = drill;
				} else {
					queue.add(new Drill(nextY, nextX, drill + 1));
					min[nextY][nextX] = drill + 1;
				}

			}
		}

	}
}

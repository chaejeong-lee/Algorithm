import java.io.*;

public class Main {
    static int n, k, ansX, ansY;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n][n];

        makeMap(0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(ansX).append(" ").append(ansY);
        System.out.println(sb);
    }

    public static void makeMap(int x, int y) {
        int i = 0, num = n * n;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (num > 0) {
            map[x][y] = num--;
            if (map[x][y] == k) {
                ansX = x + 1;
                ansY = y + 1;
            }

            if (x + dx[i] < 0 || y + dy[i] < 0 || x + dx[i] >= n || y + dy[i] >= n // 범위를 벗어나거나
                    || map[x + dx[i]][y + dy[i]] != 0) { // 이미 방문한 지점인 경우
                // 방향 바꾸기
                i = (i + 1) % 4;
            }

            x += dx[i];
            y += dy[i];
        }
    }
}
import java.io.*;
import java.util.*;
 
public class Main {
    static int N;
    static int[][] arr;
    static long[][] cnt;
    static int[] px = new int[]{1, 0};
    static int[] py = new int[]{0, 1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        cnt = new long[N][N];
 
        for (long[] col : cnt)
            Arrays.fill(col, -1);
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
 
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
 
        solve(0, 0);
 
        bw.write(String.valueOf(cnt[0][0]));
        br.close();
        bw.close();
    }
 
    public static long solve(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            return 1;
        }
 
        if (cnt[x][y] == -1) {
            cnt[x][y] = 0;
            for (int d = 0; d < 2; d++) {
                int nx = x + px[d] * arr[x][y];
                int ny = y + py[d] * arr[x][y];
 
                if (!isIn(nx, ny)) continue;
                cnt[x][y] += solve(nx, ny);
            }
        }
 
        return cnt[x][y];
    }
 
    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
}
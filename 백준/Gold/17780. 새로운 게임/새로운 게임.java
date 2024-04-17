import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
		
	static class Node {
		int r, c, dir;
		
		public Node(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	private static final int WHITE = 0;
	private static final int RED = 1;
	private static final int BLUE = 2;
	private static final int[] change = {1, 0, 3, 2};
	
	private static int N, K;
	private static int[][] map;
	private static LinkedList<Integer>[][] states;
	private static Node[] horses;
	
	private static int[] dr = {0, 0, -1, 1};
	private static int[] dc = {1, -1, 0, 0};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		states = new LinkedList[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				states[i][j] = new LinkedList<>();
			}
		}
		
		// 말의 정보
		horses = new Node[K+1];
		for(int i=1;i<=K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;
			horses[i] = new Node(r, c, dir);
			states[r][c].add(i);
		}
		
		System.out.println(solution());
	}

	private static int solution() {
		boolean flag = true;
        int times = 0;
        while (flag) {
            times++;
            if (times > 1000)
                break;

            for (int i = 1; i <= K; i++) {
                Node h = horses[i];
                int r = h.r;
                int c = h.c;

                // 가장 아래쪽 말이 아니라면 PASS
                if (states[r][c].get(0) != i)
                    continue;

                int nr = r + dr[h.dir];
                int nc = c + dc[h.dir];

                // 말이 이동하려는 칸이 파란색인 경우 + 체스판을 벗어나는 경우
                if (!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    // 방향 반대로
                    h.dir = change[h.dir];
                    nr = r + dr[h.dir];
                    nc = c + dc[h.dir];
                }

                // 방향을 반대로 한 후에 이동하려는 칸이 파란색인 경우
                if (!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    continue;
                }
                // 말이 이동하려는 칸이 빨간색인 경우
                else if (map[nr][nc] == RED) {
                    // 순서를 반대로 모든 말이 이동
                    for (int j = states[r][c].size() - 1; j >= 0; j--) {
                        int tmp = states[r][c].get(j);
                        states[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    states[r][c].clear();
                }
                // 말이 이동하려는 칸이 흰색인 경우
                else {
                    for (int j = 0; j < states[r][c].size(); j++) {
                        int tmp = states[r][c].get(j);
                        states[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    states[r][c].clear();
                }

                // 이동한 곳에 말이 4개 이상 있는가?
                if (states[nr][nc].size() >= 4) {
                    flag = false;
                    break;
                }
            }
        }
        return flag ? -1 : times;
	}
	
	private static boolean isRange(int r, int c) {
        return (0 <= r && r < N && 0 <= c && c < N);
    }
}
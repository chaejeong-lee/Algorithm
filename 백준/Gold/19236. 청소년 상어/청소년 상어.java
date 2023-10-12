import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Fish {
	int num;
	int r, c;
	int dir;
	boolean isAlive = true;

	public Fish(int num, int r, int c, int dir, boolean isAlive) {
		super();
		this.num = num;
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.isAlive = isAlive;
	}
}

public class Main {

	// 반시계
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static int[][] map;// 전체 맵
	static Fish[] fish;// 물고기 정보 저장
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		map = new int[4][4];
		fish = new Fish[17];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				fish[num] = new Fish(num, i, j, dir, true);
				map[i][j] = num;
			}
		}

		int dir = fish[map[0][0]].dir;
		int eat = map[0][0];
		fish[map[0][0]].isAlive = false;
		map[0][0] = -1;

		// 상어의 초기 위치 (r, c), 초기 상어의 방향, 먹은 물고기 번호 합 저장
		dfs(0, 0, dir, eat);
		System.out.println(answer);
	}

	private static void dfs(int Sharkr, int Sharkc, int SharkDir, int eat) {
		answer = Math.max(answer, eat);

		// 복사
		int[][] tmp = new int[4][4];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}

		// 물고기 정보 저장된 배열 복사
		Fish[] tmpFish = new Fish[17];
		for (int i = 1; i < 17; i++) {
			tmpFish[i] = new Fish(fish[i].num, fish[i].r, fish[i].c, fish[i].dir, fish[i].isAlive);
		}

		moveFish();
		
		for(int i=1;i<4;i++) {
			int nr = Sharkr + dr[SharkDir]*i;
			int nc = Sharkc + dc[SharkDir]*i;
			
			if(isRange(nr, nc) && map[nr][nc] != 0) {
				int eatFish = map[nr][nc];
				int nextDir = fish[eatFish].dir;
				map[Sharkr][Sharkc] = 0;
				map[nr][nc] = -1;
				fish[eatFish].isAlive = false;
				
				dfs(nr, nc, nextDir, eat + eatFish);
				
				//원상복구
				fish[eatFish].isAlive = true;
				map[Sharkr][Sharkc] = -1;
				map[nr][nc] = eatFish;
			}
		}
		
		//맵 원상복구
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				map[i][j] = tmp[i][j];
			}
		}
		
		// 물고기 정보 원상복구
		for(int i=1;i<17;i++) {
			fish[i] = new Fish(tmpFish[i].num, tmpFish[i].r, tmpFish[i].c, tmpFish[i].dir, tmpFish[i].isAlive);
		}
		
	}

	private static void moveFish() {
		for (int i = 1; i < 17; i++) {
			// 물고기가 죽은 경우 넘기기
			if (!fish[i].isAlive)
				continue;

			int cnt = 0;
			int dir = fish[i].dir;

			while (cnt < 8) {
				dir %= 8;
				fish[i].dir = dir;

				int nr = fish[i].r + dr[dir];
				int nc = fish[i].c + dc[dir];

				if (isRange(nr, nc) && map[nr][nc] != -1) {
					if (map[nr][nc] == 0) {
						map[fish[i].r][fish[i].c] = 0;
						fish[i].r = nr;
						fish[i].c = nc;
						map[nr][nc] = i;
					} else {
						int tmpFish = fish[map[nr][nc]].num;
						fish[tmpFish].r = fish[i].r;
						fish[tmpFish].c = fish[i].c;
						map[fish[tmpFish].r][fish[tmpFish].c] = tmpFish;
						
						fish[i].r = nr;
						fish[i].c = nc;
						map[nr][nc] = i;
					}
					break;
				}
				else {
					dir++;
					cnt++;
				}
			}
		}
	}
	

	private static boolean isRange(int r, int c) {
		return 0 <= r && 0 <= c && r < 4 && c < 4;
	}
}
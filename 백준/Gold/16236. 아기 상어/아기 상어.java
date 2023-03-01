import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish{
	int r, c, dist;

	public Fish(int r, int c, int dist) {
		this.r = r;
		this.c = c;
		this.dist = dist;
	}
}

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Fish shark;
	static ArrayList<Fish>huntFishList = new ArrayList<>();//사냥할 물고기 리스트
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int sharkSize = 2;//상어 초기 사이즈
	static int EatCnt=0, time=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Fish(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		
		Fishing();
		System.out.println(time);
	}
	
	private static void Fishing() {
		Queue<Fish> q = new LinkedList<>();
		q.add(shark);
		visited[shark.r][shark.c] = true;
		
		while(true) {
			while(!q.isEmpty()) {
				Fish cur = q.poll();
				
				for(int i=0;i<4;i++) {
					int nr = cur.r + dir[i][0];
					int nc = cur.c + dir[i][1];
					
					if(nr<0 || nc<0 || nr>=N || nc >=N)
						continue;
					
					if(visited[nr][nc])
						continue;
					
					//먹을 수 있음(사이즈가 작음, 0이 아닌 경우)
					if(map[nr][nc] < sharkSize && map[nr][nc] != 0) {
						visited[nr][nc] = true;
						huntFishList.add(new Fish(nr, nc, cur.dist+1));
						q.add(new Fish(nr, nc, cur.dist+1));
					}
					
					//사이즈가 같은 경우(먹을 수 X, 이동 O)
					if(map[nr][nc] == sharkSize || map[nr][nc] == 0) {
						visited[nr][nc] = true;
						q.add(new Fish(nr, nc, cur.dist+1));
					}
				}
			}
			
			if(huntFishList.size()==0)//먹을 물고기가 없는 경우
				return;
			else
				q = eating(q);
		}
	}
	
	private static Queue<Fish> eating(Queue<Fish> q) {
		Fish huntFish = huntFishList.get(0);
		for(int i=1;i<huntFishList.size();i++) {
			if(huntFish.dist > huntFishList.get(i).dist) {
				huntFish = huntFishList.get(i);
			}else if(huntFish.dist == huntFishList.get(i).dist) {
				//가장 위에 있는 물고기
				if(huntFish.r>huntFishList.get(i).r) {
					huntFish = huntFishList.get(i);
				}else if(huntFish.r == huntFishList.get(i).r) {
					//가장 왼쪽
					if(huntFish.c > huntFishList.get(i).c) {
						huntFish = huntFishList.get(i);
					}
				}
			}
		}
		
		time += huntFish.dist;
		EatCnt++;
		map[huntFish.r][huntFish.c] = 0;//사냥한 경우 0으로
		huntFishList.clear();
		
		if(EatCnt == sharkSize) {
			sharkSize++;
			EatCnt = 0;
		}
		
		//상어 위치 초기화
		q.clear();
		visited = new boolean[N][N];
		q.add(new Fish(huntFish.r, huntFish.c, 0));
		
		return q;
	}
}

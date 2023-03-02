import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static final int CHANCE = 5;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(answer);
	}
	
	private static void dfs(int idx) {
		if(idx == CHANCE) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					answer = Math.max(answer, map[i][j]);
				}
			}
			return;
		}
		
		int[][] copyMap = new int[N][N];
		for(int j=0;j<N;j++) {
			copyMap[j] = map[j].clone();
		}
		
		//우, 좌, 하, 상
		for(int i=0;i<4;i++) {
			move(i);
			dfs(idx+1);
			for(int j=0;j<N;j++) {
				map[j] = copyMap[j].clone();
			}
		}
	}
	
	
	private static void move(int dir) {
		LinkedList<Integer> list = new LinkedList<>();
		
		if(dir == 0) {									//우
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] != 0) {
						list.add(map[i][j]);
					}
					map[i][j] = 0;
				}

				int idx= 0;
				while(!list.isEmpty()) {
					Integer cur = list.poll();
					
					if(map[i][idx]==0) {
						map[i][idx] = cur;
					}
					else if(map[i][idx] == cur) {//숫자 같으면 병합
						map[i][idx] = cur* 2;
						idx++;
					}
					else {
						idx++;
						map[i][idx] = cur;
					}
				}
			}
			
		}
		else if(dir == 1) {								//좌
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=0;j--) {
					if(map[i][j] != 0) {
						list.add(map[i][j]);
					}
					map[i][j] = 0;
				}
				
				int idx = N-1;
				while(!list.isEmpty()) {
					Integer cur = list.poll();
					
					if(map[i][idx]==0) {
						map[i][idx] = cur;
					}
					else if(map[i][idx] == cur) {//숫자 같으면 병합
						map[i][idx]= cur* 2;
						idx--;
					}
					else {
						idx--;
						map[i][idx] = cur;
					}
				}
			}
			
		}
		else if(dir == 2) {								//하
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=0;j--) {
					if(map[j][i] != 0) {
						list.add(map[j][i]);
					}
					map[j][i] = 0;
				}

				int idx = N-1;
				while(!list.isEmpty()) {
					Integer cur = list.poll();
					
					if(map[idx][i]==0) {
						map[idx][i] = cur;
					}
					else if(map[idx][i] == cur) {//숫자 같으면 병합
						map[idx][i]= cur* 2;
						idx--;
					}
					else {
						idx--;
						map[idx][i] = cur;
					}
				}
			}
		}
		else if(dir == 3) {								//상
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[j][i] != 0) {
						list.add(map[j][i]);
					}
					map[j][i] = 0;
				}

				int idx = 0;
				while(!list.isEmpty()) {
					Integer cur = list.poll();
					
					if(map[idx][i]==0) {
						map[idx][i] = cur;
					}
					else if(map[idx][i] == cur) {//숫자 같으면 병합
						map[idx][i] = cur* 2;
						idx++;
					}
					else {
						idx++;
						map[idx][i] = cur;
					}
				}
			}
		}
	}
}

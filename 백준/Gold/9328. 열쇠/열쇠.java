import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static int w, h;
	private static char[][] map;
	private static boolean[][] visited;
	private static boolean[] keys;
	private static ArrayList<Point>[] doors;
	private static int cnt;
	
	private static int[] dr = {0, -1, 0, 1};
	private static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h+2][w+2];
			visited = new boolean[h+2][w+2];
			keys = new boolean[26];
			doors = new ArrayList[26];
			cnt = 0;
			
			// 문 초기화
			for(int i=0;i<26;i++) {
				doors[i] = new ArrayList<>();
			}
			
			// 빈칸으로 맵 채우기
			for(int i=0;i<h+2;i++) {
				for(int j=0;j<w+2;j++) {
					map[i][j] = '.';
				}
			}
			
			// 맵 입력
			for(int i=1;i<h+1;i++) {
				String str = br.readLine();
				for(int j=1;j<w+1;j++) {
					map[i][j] = str.charAt(j-1);
				}
			}
			
			String keyStr = br.readLine();
			if(!keyStr.equals("0")) {
				for(int i=0;i<keyStr.length();i++) {
					int keysNumber = keyStr.charAt(i)-'a';
					keys[keysNumber] = true;
				}
			}
			
			bfs();
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				// 범위 체크
				if(nr<0 || nc<0 || nr>=h+2 || nc>=w+2) continue;
				
				// 방문한 적있거나, 벽이거나
				if(visited[nr][nc] || map[nr][nc] == '*') continue;
				
				char now = map[nr][nc];
				
				if(now-'A'>=0 && now-'A'<=25) {
					// 문 발견
					// 1. 열쇠가 존재하는 경우
					// 2. 열쇠가 존재하지 않는 경우
					if(keys[now-'A']) {
						map[nr][nc] = '.';
						visited[nr][nc] = true;
						q.add(new Point(nr, nc));
					}
					else {
						// 문만 저장해두기
						doors[now-'A'].add(new Point(nr, nc));
					}
				}
				else if(now-'a'>=0 && now-'a'<=25) {
					// 열쇠 발견 - 문 열기
					keys[now-'a'] = true;
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
					
					for(int i=0;i<26;i++) {
						if(doors[i].size() != 0 && keys[i]) {
							for(int j=0;j<doors[i].size();j++) {//문이 여러개일 수도 있으니까, 그거에 맞춰서 하는 것
								Point tmp = doors[i].get(j);
								map[tmp.r][tmp.c] = '.';
								visited[tmp.r][tmp.c] = true;
								q.add(new Point(tmp.r, tmp.c));
							}
						}
					}
				}
				else if(now == '$') {
					// 문서 찾기
					cnt++;
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
				else {
					// 빈 곳
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}
	}
}
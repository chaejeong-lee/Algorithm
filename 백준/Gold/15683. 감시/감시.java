import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointCCTV{
	int r, c;
	int cctvNum;
	
	public PointCCTV(int r, int c, int cctvNum) {
		this.r = r;
		this.c = c;
		this.cctvNum = cctvNum;
	}
}

public class Main {
	
	static int N, M;
	static int[][] board, copyBoard;
	static int[] cctvPer;
	static ArrayList<PointCCTV> cctvList;
	static int answer = Integer.MAX_VALUE;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//상, 우, 하, 좌

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		cctvList = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				board[i][j]= Integer.parseInt(st.nextToken()); 
				if(board[i][j] != 0 && board[i][j] != 6) {
					cctvList.add(new PointCCTV(i, j, board[i][j]));
				}
			}
		}
		cctvPer = new int[cctvList.size()];//cctv 순열 담을 배열 선언
		permutation(0, cctvList.size());
		
		System.out.println(answer);
	}

	private static void permutation(int cnt, int r) {
		if(cnt == r) {
			copyOffice();
			for(int i=0;i<r;i++) {
				direction(cctvList.get(i), cctvPer[i]);
			}
			
			check0();//사각지대 체크하기
			return;
		}
		
		for(int i=0;i<4;i++) {
			cctvPer[cnt]= i;
			permutation(cnt+1, r);
		}
	}
	
	/**
	 * 지도 복사
	 */
	private static void copyOffice() {
		copyBoard = new int[N][M];
		for(int i=0;i<N;i++) {
			copyBoard[i] = Arrays.copyOf(board[i], M);
		}
	}
	
	/**
	 * CCTV
	 * @param pc : 현재 해당하는 CCTV Point
	 * @param d : 방향
	 */
	private static void direction(PointCCTV pc, int d) {
		int cNum = pc.cctvNum;
		
		if(cNum==1) {					//1번 CCTV	
			CCTVCheck(pc, d);
		}
		else if(cNum==2) {				//2번 CCTV
			CCTVCheck(pc, d);
			CCTVCheck(pc, (d+2)%4);
		}
		else if(cNum==3) {				//3번 CCTV
			CCTVCheck(pc, d);
			CCTVCheck(pc, (d+1)%4);
		}
		else if(cNum==4) {				//4번 CCTV
			CCTVCheck(pc, d);
			CCTVCheck(pc, (d+1)%4);
			CCTVCheck(pc, (d+2)%4);
		}
		else if(cNum==5) {				//5번 CCTV
			CCTVCheck(pc, 0);
			CCTVCheck(pc, 1);
			CCTVCheck(pc, 2);
			CCTVCheck(pc, 3);
		}
		
	}
	
	private static void CCTVCheck(PointCCTV pc, int d) {
		Queue<PointCCTV> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.add(pc);
		visited[pc.r][pc.c] = true;
		
		while(!queue.isEmpty()) {
			int nr = queue.peek().r + dir[d][0];
			int nc = queue.poll().c + dir[d][1];
			
			if(nr<0 || nc<0 || nr>=N || nc>=M || copyBoard[nr][nc] == 6) break;
			
			if(copyBoard[nr][nc]==0) 
				copyBoard[nr][nc] = 9;
			queue.add(new PointCCTV(nr, nc, pc.cctvNum));
		}
	}

	private static void check0() {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyBoard[i][j] == 0) cnt++;
			}
		}
		answer = Math.min(answer, cnt);
	}
}

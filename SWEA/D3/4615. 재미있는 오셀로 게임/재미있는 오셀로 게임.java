import java.util.*;

public class Solution {
	static int[][] board;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();//한변의 길이 (4, 6, 8만 가능)
			int M = sc.nextInt();//플레이어가 돌을 놓을 수 있는 횟수
			
			board = new int[N][N];
			
			init(board, N);
			
			int bcnt=0;
			int wcnt=0;
			
			for(int i=0;i<M;i++) {
				int x=sc.nextInt()-1;//x값
				int y = sc.nextInt()-1;//y값
				int color = sc.nextInt();//돌 색 (1: 흑 / 2: 백)
				
				board[x][y]=color;
				searchAndReplace(x, y, color, N);
			}
			
			for(int[] temp:board) {//돌 개수
				for(int tempval:temp) {
					if(tempval==1) bcnt++;
					else if(tempval==2) wcnt++;
				}
			}
			
			sb.append("#"+test_case+" "+bcnt+" "+wcnt+"\n");
		}
		System.out.print(sb);
	}

	//맵 초기화
	private static void init(int[][] arr, int N) {
		//1 : 흑돌, 2 : 백돌
		arr[N/2][N/2]=2;
		arr[N/2-1][N/2]=1;
		arr[N/2][N/2-1]=1;
		arr[N/2-1][N/2-1]=2;
	}
	
	//주변 돌 탐색 후 돌 교체 과정
	private static void searchAndReplace(int x, int y, int color, int N) {
		for(int ix=-1;ix<=1;ix++) {//(x,y) 주변에 돌이 있는지 탐색
			for(int iy=-1;iy<=1;iy++) {
				if(ix==0 && iy ==0) {//본인 돌 위치이므로 통과함
					continue;
				}
				//(x, y) 주변에 존재하는 돌 좌표
				int xx = x + ix;
				int yy = y + iy;
				
				boolean check = false;//(xx, yy)가 자신의 색 돌이 맞는지 체크
				while(xx>=0 && yy>=0 && xx<N && yy<N && board[xx][yy]!=0) {//범위를 벗어나지 않는 경우여야 확인할 수 있음, 돌이 있어야 함
					if(board[xx][yy]==color) {//(xx, yy)가 자신의 색 돌일 경우
						check = true;
						break;
					}
					xx += ix;//상대의 돌일 경우 자신의 돌이 나올 떼까지 탐색
					yy += iy;
				}
				while(check) {
					if(xx==x && yy==y) {//상대 돌을 자신의 돌로 교체
						break;
					}
					board[xx][yy]=color; 
					xx -= ix;
					yy -= iy;
				}
			}
			
		}
	}
}
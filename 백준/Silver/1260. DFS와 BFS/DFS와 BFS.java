import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] check;//간선 연결 상태
	static boolean[] checked;//확인 여부
	static int N;
	static int M;
	static int V;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//정점의 개수
		M = sc.nextInt();//간선의 개수
		V = sc.nextInt();//시작 정점
		
		check = new int[1001][1001];//좌표를 그대로 받아들이기 위하여 +1
		checked = new boolean[1001];//초기값 False
		
		for(int i = 0 ; i<M ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			check[x][y]=check[y][x]=1;
		}
		
		dfs(N, V);
		
		checked = new boolean[1001];//bfs를 위해 다시 선언
		System.out.println();
		bfs();
	}

	//시작점을 변수로 받아서 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
	public static void dfs(int N, int i) {
		checked[i] = true;
		System.out.print(i+" ");
		
		for(int j = 1; j<=N; j++) {
			if(check[i][j]== 1 && checked[j]==false) {
				dfs(N, j);
			}
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);//시작점에queue에 넣어야 함
		checked[V] = true;
		System.out.print(V+" ");
		
		//Queue가 빌 때까지 반복
		//방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int j = 0 ; j<= N; j++) {
				if(check[temp][j]==1 && checked[j] == false) {
					queue.offer(j);
					checked[j] = true;
					System.out.print(j+" ");
				}
			}
		}
	}
}
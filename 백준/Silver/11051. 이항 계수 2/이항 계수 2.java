import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//파스칼 삼각형 생각
		int N = sc.nextInt();//위에 이기 때문에 열에서 최대값
		int K = sc.nextInt();//그 마지막 열에 몇번째에 있는지
		
		int[][] triangle = new int[N+1][N+1];//0부터 시작하기 때문에 1을 더 해서 구해줘야 함
		
		for(int i=0;i<triangle.length;i++) {//N까지 구해야 하기 때문에 N길이까지 하면 됨
			for(int j=0;j<=i;j++) {
				if(i==j||j==0) triangle[i][j]=1;//사이드 부분은 모두 1이기 때문에(파스칼 삼각형)
				else triangle[i][j]= (triangle[i-1][j-1] + triangle[i-1][j])%10007;//우리가 구해야 하는 것이 나머지이기 때문에 나머지를 배열에 저장 
			}
		}
		System.out.println(triangle[N][K]);
	}
}
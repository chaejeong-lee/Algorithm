import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long[] distance = new long[N-1];
		long[] cost = new long[N];
		
		//거리 값 받기
		for(int i=0;i<distance.length;i++) {
			distance[i] = sc.nextLong();
		}
		
		//주유소 비용 받기
		for(int i=0;i<cost.length;i++) {
			cost[i] = sc.nextLong();
		}
		
		long sum = 0;//총 비용
		long minCost = cost[0];
		
		for(int i=0;i<distance.length;i++) {
			if(cost[i]<minCost) minCost = cost[i];
			
			sum += (minCost*distance[i]);
		}
		System.out.println(sum);
	}

}

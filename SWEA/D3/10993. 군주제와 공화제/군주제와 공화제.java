import java.security.Policy;
import java.util.Scanner;

class City{
	public int x;
	public int y;
	public int s;
	
	public int policy = 1001;//1001 - 군주제, 1002 - 공화정
	public City(int x, int y, int s) {
		this.x = x;
		this.y = y;
		this.s = s;
	}
	
	public double cal(City city) {
		return (double)this.s/((this.x-city.x)*(this.x-city.x)+(this.y-city.y)*(this.y-city.y));
	}
}

public class Solution {
	static City citys[];
	
	public static void main(String[] args) throws Exception {
		Scanner sc =new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();//테스트 케이스
		
		for(int test_case =1; test_case<=T;test_case++) {
			int N = sc.nextInt();//도시의 수
			citys = new City[N];
			
			for(int i=0;i<N;i++) {
				citys[i]= new City(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			
			for(int i =0 ; i<N;i++) {
				double max = 0;
				for(int j =0 ; j<N ;j++) {
					if(i==j) continue;
					double threat = citys[j].cal(citys[i]);
					if(citys[i].s<threat) {
						if(max <threat) {
							max = threat;
							citys[i].policy=j;
						}
						else if(max == threat) citys[i].policy=1002;
					}
				}
			}
			for(int i=0;i<N;i++) {
				if(citys[i].policy>1000) continue;
				int next = citys[i].policy;
				while(true) {
					if(next>1000) break;
					citys[i].policy = next;
					next = citys[next].policy;
				}
			}
			
			sb.append("#"+test_case+" ");
			for(int i=0;i<N;i++) {
				if(citys[i].policy==1001) sb.append("K ");
				else if(citys[i].policy==1002) sb.append("D ");
				else sb.append((citys[i].policy+1)+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
}
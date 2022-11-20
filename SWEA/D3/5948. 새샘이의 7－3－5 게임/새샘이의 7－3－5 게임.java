import java.util.*;

//7개의 서로 다른 정수 중 3개 골라서 합 구하기
//5번째로 큰 수 출력
public class Solution {
	static int num_size=7;
	static int SIZE=3;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			List<Integer> list = new ArrayList<>();
			HashSet<Integer> set = new HashSet<>();
			for(int i=0;i<num_size;i++) {
				list.add(sc.nextInt());
			}
			solve(0, 0, 0, list, set);
			
			List answer = new ArrayList(set);
			Collections.sort(answer, Collections.reverseOrder());
			sb.append("#"+test_case+" "+answer.get(4)+"\n");
		}
		System.out.print(sb);
	}
	
	private static void solve(int i, int sum, int size, List<Integer> list, HashSet<Integer> set) {
		if(size>=SIZE) {
			set.add(sum);
			return;
		}
		for(int j=i;j<num_size;j++) {
			solve(j+1,  sum+list.get(j), size+1, list, set);
		}
	}
}
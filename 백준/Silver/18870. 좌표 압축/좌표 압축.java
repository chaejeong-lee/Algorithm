import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] origin = new int[N];
		int[] sorted = new int[N];
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
		
		for(int i=0 ; i<N ; i++) {
			sorted[i] = origin[i] = sc.nextInt(); 
		}
		
		Arrays.sort(sorted);
		
		int rank = 0;
		for(int v:sorted) {
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v,  rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key: origin) {
			int ranking = rankingMap.get(key);
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
	}

}

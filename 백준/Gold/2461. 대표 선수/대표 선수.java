import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());// N: 학급수
		int M = Integer.parseInt(st.nextToken());// M: 각 학급에 있는 학생 수
		
		int[][] students = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(students[i]);
		}
		
		int[] representatives = new int[N];
		int result = Integer.MAX_VALUE;
		int minIndex = 0;
		
		while(true) {
			int max = 0;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				if(students[i][representatives[i]]>max)
					max = students[i][representatives[i]];
				if(students[i][representatives[i]]<min) {
					min = students[i][representatives[i]];
					minIndex = i;
				}
			}
			result = Math.min(result, max-min);
			representatives[minIndex]++;
			if(representatives[minIndex] == M) break;
		}
		System.out.println(result);
	}
}

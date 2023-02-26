import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int small = 1, larger = 1;
		int Maxsmall = 1, Maxlarger = 1;
		
		for(int i=0;i<N-1;i++) {
			if(arr[i]<=arr[i+1]) {
				//점점 커지는 경우
				larger++;
				Maxlarger = Math.max(larger, Maxlarger);
			}else {
				larger = 1;
			}
			
			if(arr[i]>=arr[i+1]) {
				//점점 작아지는 경우
				small++;
				Maxsmall = Math.max(small, Maxsmall);
			}else {
				small= 1;
			}
			
		}
		System.out.println(Math.max(Maxlarger, Maxsmall));
	}

}
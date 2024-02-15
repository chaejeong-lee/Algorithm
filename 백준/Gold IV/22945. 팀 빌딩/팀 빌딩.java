import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] devAbilities = new int[N];
		for(int i=0;i<N;i++) {
			devAbilities[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		int left = 0;
		int right = N-1;
		
		while(left<=right) {
			int min = (right - left - 1) * Math.min(devAbilities[left], devAbilities[right]);
			answer = Math.max(answer, min);
			if(devAbilities[left]<devAbilities[right]) left++;
			else right--;
		}
		
		System.out.println(answer);
	}

}
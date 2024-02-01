import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[W];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<W;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for(int i=1;i<W-1;i++) {
			int cur = nums[i];
			int leftMax = cur;
			int rightMax = cur;
			
			for(int j=i-1;j>=0;j--) {
				if(nums[j]>cur) leftMax = Math.max(leftMax, nums[j]);
			}
			
			for(int j=i+1;j<W;j++) {
				if(nums[j]>cur) rightMax = Math.max(rightMax, nums[j]);
				
			}
			if(Math.min(leftMax, rightMax) > cur)
				answer += Math.min(leftMax, rightMax) - nums[i];
		}
		
		
		System.out.println(answer);
	}

}

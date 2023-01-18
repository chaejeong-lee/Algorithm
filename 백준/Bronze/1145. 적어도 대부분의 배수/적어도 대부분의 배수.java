import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]= sc.nextInt(); 
		}
		Arrays.sort(arr);
		
		int val = 1;
		int cnt = 0;
		
		while(true) {
			for(int k=0;k<5;k++) {
				if(val%arr[k]== 0 )
					cnt++;
			}
			if(cnt>=3) {
				System.out.println(val);
				return;
			}
			cnt=0;
			val++;
		}
	}

}
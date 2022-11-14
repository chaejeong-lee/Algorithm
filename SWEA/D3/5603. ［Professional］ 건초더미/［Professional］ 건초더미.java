import java.util.Scanner;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[] arr = new int[N];
            int sum = 0;
            for(int i = 0 ; i<N; i++){
            	arr[i] = sc.nextInt();
                sum+=arr[i];
            }
            int cnt=0;
            int mid= sum/N;
            
            for(int i = 0 ; i<N; i++){
            	if(arr[i]-mid>0) 
                    cnt += arr[i]-mid;
                else 
                    cnt += mid-arr[i];
            }
            System.out.println("#"+test_case+" "+cnt/2);
		}
	}
}
import java.util.Scanner;
import java.util.ArrayList;

class Solution
{
    static int[] num;
    static int cnt=0;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			ArrayList<Integer> arr = new ArrayList<>();
            int N = sc.nextInt();
            int A = sc.nextInt();
            num = new int[N];
            for(int i= 0 ; i < N ; i++) num[i] = sc.nextInt();
            cnt = 0;
            solve(0, 0, N, A);
            System.out.println("#"+test_case+" "+cnt);
		}
	}
    
    private static void solve(int idx, int sum,int N, int A){
    	if(sum==A){
        	cnt++;
            return;
        }
        else if(sum>A || idx >= N) return;
        solve(idx+1, sum+num[idx], N, A);
        solve(idx+1, sum, N, A);
    }
}
import java.util.Scanner;

class Solution
{
    static int MOD = 1234567891;
    static long fact[];
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        fact = new long[1000001];
        fact[0] = 1;
        
        for(int i = 1; i<1000001;i++) fact[i] = (fact[i-1]*i)%MOD;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int R = sc.nextInt();
            
            long up = fact[N];
            long down = (fact[N-R]*fact[R])%MOD;
            long refactoredDown=pow(down, MOD-2);
            
            System.out.println("#"+test_case+" "+(up*refactoredDown)%MOD);
		}
	}
    
    public static long pow(long a, long N){
    	if(N==0) return 1;
        if(N==1) return a;
        if(N%2==0){
        	long temp = pow(a, N/2);
            return(temp*temp)%MOD;
        }
        long temp = pow(a, N-1)%MOD;
        return (temp*a)%MOD;
    }
}
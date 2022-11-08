import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        String[] num = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String tc = sc.next();
            int N = sc.nextInt();
            String[] arr = new String[N];
            for(int i = 0 ; i<N;i++){
            	arr[i] = sc.next();
            }
            System.out.println(tc);
            
            for(int i = 0; i<num.length;i++){
            	for(int j = 0 ; j<N ; j++){
                	if(arr[j].equals(num[i])){
                    	System.out.print(arr[j]+" ");
                    }
                }
            }
		}
	}
}
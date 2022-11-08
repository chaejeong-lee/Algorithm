import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tc = sc.nextInt();
            Queue<Integer> encryption = new LinkedList<>();
            for(int i= 0 ; i<8;i++){
            	int v = sc.nextInt();
                encryption.add(v);
            }
            
            int value = 1;
            while(value >0){
            	for(int i = 1; i<6;i++){//한 사이클이 5번이므로
                	value = encryption.poll();
                    value -= i;
                    if(value <= 0) value= 0;
                    encryption.add(value);
                    if(value == 0) break;
                }
            }
            System.out.print("#"+tc+" ");
            for(int i = 0 ; i<8;i++){
            	System.out.print(encryption.poll()+" ");
            }
            System.out.println();
		}
	}
}
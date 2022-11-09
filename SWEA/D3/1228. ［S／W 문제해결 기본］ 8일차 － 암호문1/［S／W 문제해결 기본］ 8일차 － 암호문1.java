import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N= sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            
            for(int i = 0; i<N;i++){
            	list.add(sc.nextInt());
            }
            
            int K = sc.nextInt();//명령어의 개수
            for(int i = 0 ; i<K ; i++){
            	String s = sc.next();
                int x = sc.nextInt();//위치
                int y = sc.nextInt();//삽입할 숫자 개수
                for(int j = 0 ; j<y ;j++){
                	list.add(x, sc.nextInt());
                    x++;//다음 위치에 삽입
                }
            }
            int cnt = 0;
            System.out.print("#"+test_case+" ");
            while(!list.isEmpty()){
            	if(cnt>9){
                	break;
                }
                System.out.print(list.poll()+" ");
                cnt++;
            }
            System.out.println();
		}
	}
}
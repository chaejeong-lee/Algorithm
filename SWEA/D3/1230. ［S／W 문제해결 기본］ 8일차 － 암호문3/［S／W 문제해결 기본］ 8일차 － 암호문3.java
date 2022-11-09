import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T=10;
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            LinkedList<Integer> list = new LinkedList<>();
            int N = sc.nextInt();
             
            for(int i = 0 ;i <N ; i++) list.add(sc.nextInt());
             
            int K = sc.nextInt();//명령어 개수
             
            for(int i = 0 ; i<K ; i++){
                String s = sc.next();
                if(s.equals("I")){
                	int x = sc.nextInt();
                	int y = sc.nextInt();
                    for(int j = 0 ; j<y ; j++){
                        list.add(x, sc.nextInt());
                        x++;
                    }
                }else if(s.equals("D")){
                	int x = sc.nextInt();
                	int y = sc.nextInt();
                    for(int j = 0 ; j<y ; j++){
                        list.remove(x);
                    }
                }else if(s.equals("A")){
                	int y = sc.nextInt();
                    for(int j = 0; j<y; j++){
                    	list.add(sc.nextInt());
                    }
                }
            }
            System.out.print("#"+test_case+" ");
            for(int i = 0 ; i<10;i++){
                System.out.print(list.poll()+" ");
            }
            System.out.println();
        }
    }
}
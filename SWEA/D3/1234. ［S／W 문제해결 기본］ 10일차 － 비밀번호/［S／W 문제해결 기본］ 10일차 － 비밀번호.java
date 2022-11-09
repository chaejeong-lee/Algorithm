import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();//글자 수
            ArrayList<String> List = new ArrayList<>();
            
            String s = sc.next();
            
            for(int i = 0 ; i<n ; i++){
            	List.add(s.substring(i, i+1));
            }
            
            int cnt = 0;
            while(true){
            	if(cnt == List.size()-1) break;
                if(List.get(cnt).equals(List.get(cnt+1))){
                	List.remove(cnt);
                    List.remove(cnt);
                    cnt=0;
                }else{
                	cnt++;
                }
            }
        	System.out.print("#"+test_case+" ");
        	for(String i:List) System.out.print(i);
        	System.out.println();
		}
	}
}
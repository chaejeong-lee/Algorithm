import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		ArrayList<Boolean> primeList = new ArrayList<Boolean>();
		
		//0과 1은 소수가 아님
		primeList.add(false);
		primeList.add(false);
		
		int max = (int)Math.pow(10, 6);
		
		for(int i=2; i<=max;i++) {
			primeList.add(true);
		}
		
		for(int i=2; (i*i)<=max;i++) {
			if(primeList.get(i)) {
				for(int j=i*i;j<=max;j+=i)
					primeList.set(j, false);
			}
		}
		
		for(int i=0; i<=max ;i++) {
			if(primeList.get(i)==true) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
	}

}
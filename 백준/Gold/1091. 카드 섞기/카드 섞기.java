import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = null;
	      
	      int N = Integer.parseInt(br.readLine());
	      int[] p = new int[N];
	      int[] order = new int[N];
	      int[] cards = new int[N];
	      
	      st = new StringTokenizer(br.readLine());
	      for(int i=0;i<N;i++) p[i] = Integer.parseInt(st.nextToken());
	      
	      st = new StringTokenizer(br.readLine());
	      for(int i=0;i<N;i++) {
	         order[Integer.parseInt(st.nextToken())] = i;
	         cards[i] = i%3;
	      }
	 
	      int[] compare = cards.clone();
	      int[] next = new int[N];
	 
	      int result = 0;
	      while(!Arrays.equals(cards,p) && !(result !=0 && Arrays.equals(cards, compare))) {
	         for(int j=0;j<N;j++) next[order[j]] = cards[j];
	         
	         cards = next.clone();
	         result++;
	      }
	   
	      if(result !=0 && Arrays.equals(cards, compare)) System.out.println(-1);
	      else System.out.println(result);
	}

}

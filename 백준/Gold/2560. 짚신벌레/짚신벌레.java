import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int death = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            if (i<start) 
                dp[i] = dp[i-1]%1000;
            else if(i<end)
                dp[i] = (dp[i-1] + dp[i-start])%1000;
            else
                dp[i] = (dp[i-1]+dp[i-start]-dp[i-end]+1000)%1000;
        }

        if(N-death>=0)
            System.out.println((dp[N]-dp[N-death]+1000)%1000);
            
        else System.out.println(dp[N]%1000);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		StringTokenizer st_1 = new StringTokenizer(s,"0");
		StringTokenizer st_0 = new StringTokenizer(s,"1");
		
		System.out.println(Math.min(st_1.countTokens(), st_0.countTokens()));
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			list.add(s.substring(i));
		}
		
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}

}
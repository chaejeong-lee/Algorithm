import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		String S = st.nextToken();// 개강총회를 시작한 시간
		String E = st.nextToken();// 개강총회를 끝낸 시간
		String Q = st.nextToken();// 개강총회 스트리밍을 끝낸 시간

		// 시작할 때 출석체크
		HashSet<String> start = new HashSet<>();
		// 끝날 때 출석체크
		HashSet<String> end = new HashSet<>();

		String input = null;
		while ((input = br.readLine()) != null) {
			st = new StringTokenizer(input, " ");
			String time = st.nextToken();
			String name = st.nextToken();
			if (S.compareTo(time) >= 0)
				start.add(name);
			else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0)
				end.add(name);

		}

		int cnt = 0;

		for(String s:end) {
			if(start.contains(s)) cnt++;
		}
		System.out.println(cnt);
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] switches = new int[N];

		st = new StringTokenizer(br.readLine());// 스위치 : 1 - 켜짐 / 0 - 꺼짐
		for (int i = 0; i < N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int stdCnt = Integer.parseInt(br.readLine());// 학생 수
		for (int i = 0; i < stdCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());// 성별 : 남자 - 1 / 여자 - 0
			int num = Integer.parseInt(st.nextToken());// 받은 수

			if (sex == 1) {// 남자일 경우
				for (int j = 0; j < switches.length; j++) {
					if ((j + 1) % num == 0)
						switches[j] = (switches[j] == 0 ? 1 : 0);
				}
			} else {// 여자일 경우
				switches[num - 1] = (switches[num - 1] == 0 ? 1 : 0);
				int j = 1;
				while (num - j - 1 >= 0 && num + j - 1 < N && (switches[num - j - 1] == switches[num + j - 1])) {
					switches[num - j - 1] = (switches[num - j - 1] == 0 ? 1 : 0);
					switches[num + j - 1] = switches[num - j - 1];
					j++;
				}
			}
		}
		for (int i = 0; i < switches.length; i++) {
			sb.append(switches[i] + " ");
			if ((i + 1) % 20 == 0)
				sb.append("\n");
		}
		System.out.print(sb);
	}

}
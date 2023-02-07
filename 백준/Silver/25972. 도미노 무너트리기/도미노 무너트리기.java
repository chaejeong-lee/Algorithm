import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());// i번째
			arr[i][1] = Integer.parseInt(st.nextToken());// 길이 : l
		}

		Arrays.sort(arr, Comparator.comparingLong(o1 -> o1[0]));

		int num = arr[0][0]+arr[0][1];
		for (int i = 0; i < N; i++) {
			if (num < arr[i][0])
				cnt++;
			num = arr[i][0] + arr[i][1];
		}
		System.out.println(cnt);

	}

}

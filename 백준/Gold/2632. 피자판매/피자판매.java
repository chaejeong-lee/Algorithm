import java.util.*;
import java.io.*;

public class Main {

	public static int totalPizzaSize, aTotalPizzaCnt, bTotalPizzaCnt;
	public static int[] aPizzaSize, bPizzaSize, aPizzaCnt, bPizzaCnt;
	public static int aMaxPizzaCnt = 0, bMaxPizzaCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		totalPizzaSize = Integer.parseInt(br.readLine()); // 피자 크기

		st = new StringTokenizer(br.readLine(), " ");
		aTotalPizzaCnt = Integer.parseInt(st.nextToken()); // aTotalPizzaCnt: A 피자조각 개수
		bTotalPizzaCnt = Integer.parseInt(st.nextToken()); // bTotalPizzaCnt: B 피자조각 개수

		aPizzaSize = new int[aTotalPizzaCnt];
		bPizzaSize = new int[bTotalPizzaCnt];

		for (int i = 0; i < aTotalPizzaCnt; i++) {
			aPizzaSize[i] = Integer.parseInt(br.readLine());
			aMaxPizzaCnt += aPizzaSize[i];
		}

		for (int i = 0; i < bTotalPizzaCnt; i++) {
			bPizzaSize[i] = Integer.parseInt(br.readLine());
			bMaxPizzaCnt += bPizzaSize[i];
		}

		aPizzaCnt = new int[Math.max(aMaxPizzaCnt, totalPizzaSize) + 1];
		aPizzaCnt[0] = 1;
		aPizzaCnt[aMaxPizzaCnt] = 1;
		pizzaCntFunc(aPizzaSize, aPizzaCnt);

		bPizzaCnt = new int[Math.max(bMaxPizzaCnt, totalPizzaSize) + 1];
		bPizzaCnt[0] = 1;
		bPizzaCnt[bMaxPizzaCnt] = 1;
		pizzaCntFunc(bPizzaSize, bPizzaCnt);

		int answer = 0;
		for (int i = 0; i <= totalPizzaSize; i++) {
			answer += (aPizzaCnt[i] * bPizzaCnt[totalPizzaSize - i]);
		}
		System.out.println(answer);
	}

	public static void pizzaCntFunc(int[] pizzaSize, int[] pizzaCnt) {
		for (int i = 0; i < pizzaSize.length; i++) {
			int sum = 0;
			for (int j = 1; j < pizzaSize.length; j++) {
				int sumJ = pizzaSize[(i + j) % pizzaSize.length];
				if (sum + sumJ > totalPizzaSize)
					break;

				sum += sumJ;
				pizzaCnt[sum]++;
			}
		}
	}
}
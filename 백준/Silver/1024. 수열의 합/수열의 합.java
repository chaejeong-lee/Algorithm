import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int L = sc.nextInt();

        while (true) {
            int min = N / L - (L - 1) / 2;

            if (min < 0 || L > 100) {
                sb.append(-1);
                break;
            }

            int sum = L * (min * 2 + (L - 1)) / 2;

            if (sum == N) {
                for (int i = 0; i < L; i++) {
                    sb.append((min + i) + " ");
                }
                break;
            }

            L++;
        }

        System.out.println(sb);
        sc.close();
    }
}
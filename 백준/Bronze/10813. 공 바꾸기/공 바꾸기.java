import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            int tmp;
            int F = sc.nextInt();
            int E = sc.nextInt();

            tmp = arr[F-1];
            arr[F-1] = arr[E-1];
            arr[E-1] = tmp;
        }
        sc.close();

        for (int baguni : arr)
            System.out.print(baguni + " ");
    }
}
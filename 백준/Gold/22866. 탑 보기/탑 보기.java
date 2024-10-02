import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n, l;
    static String[] strArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Stack<int[]> stack = new Stack<>();

        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            answer.add(new int[] {0, 0});
        }

        stack.add(new int[]{1, arr[1]});
        for (int i = 2; i <= n; i++) {
            int[] my = answer.get(i);

            while (!stack.isEmpty()){
                int[] peek = stack.peek();
                if (peek[1] <= arr[i]){
                    stack.pop();
                }else
                    break;
            }

            if (!stack.isEmpty()){
                int[] peek = stack.peek();
                my[1] = peek[0];
            }
            my[0] += stack.size();
            stack.add(new int[]{i, arr[i]});
        }

        stack.clear();

        stack.add(new int[]{n, arr[n]});
        for (int i = n - 1; i >= 1; i--) {
            int[] my = answer.get(i);

            while (!stack.isEmpty()){
                int[] peek = stack.peek();
                if (peek[1] <= arr[i]){
                    stack.pop();
                }else
                    break;
            }

            if (!stack.isEmpty()){
                int[] peek = stack.peek();
                if (my[0] == 0)
                    my[1] = peek[0];
                else{
                    int prevdis = Math.abs(i - my[1]);
                    int nowdis =  Math.abs(i - peek[0]);
                    if (nowdis < prevdis)
                        my[1] = peek[0];
                }
            }
            my[0] += stack.size();
            stack.add(new int[]{i, arr[i]});
        }

        for (int i = 1; i <= n; i++) {
            int[] list = answer.get(i);
            if (list[0] == 0){
                System.out.println(0);
            }else{
                System.out.println(list[0] + " " + list[1]);
            }
        }

    }

}
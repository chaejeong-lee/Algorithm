import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
 
    static int n, k, result;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        solve();
        System.out.println(result);
    }
 
    public static void solve() {
        for (int i = 1; i < n; i++) {
            list.add(arr[i] - arr[i - 1]);
        }
 
        Collections.sort(list);
 
        for (int i = 0; i < n - k; i++) {
            result+=list.get(i);
        }
    }
}
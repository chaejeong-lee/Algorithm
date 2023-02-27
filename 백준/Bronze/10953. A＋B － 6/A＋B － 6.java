import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String[] arr = sc.next().split(",");
            System.out.println(Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
        }
    }
}
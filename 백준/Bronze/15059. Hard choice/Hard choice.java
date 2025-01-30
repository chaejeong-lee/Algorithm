import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
 
        Scanner sc = new Scanner(System.in);
        
        int ca = sc.nextInt();
        int ba = sc.nextInt();
        int pa = sc.nextInt();
        
        int cr = sc.nextInt();
        int br = sc.nextInt();
        int pr = sc.nextInt();
 
        int result = 0;
        if (cr - ca > 0) {
            result += cr - ca;
        }
        if (br - ba > 0) {
            result += br - ba;
        }
        if (pr - pa > 0) {
            result += pr - pa;
        }
        
        System.out.print(result);
        
    }
}
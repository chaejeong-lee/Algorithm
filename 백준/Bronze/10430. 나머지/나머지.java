import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(2<=A && A<=10000 && 2<=B && B<=10000 && 2<=C && C<=10000) {
			System.out.println((A+B)%C);
			System.out.println(((A%C)+(B%C))%C);
			System.out.println((A*B)%C);
			System.out.println(((A%C)*(B%C))%C);
			
		}
	}

}
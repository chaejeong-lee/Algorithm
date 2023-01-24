import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		
		String[] Aminmax = new String[2];
		Aminmax = change(A);
		String[] Bminmax = new String[2];
		Bminmax = change(B);

		int min = Integer.parseInt(Aminmax[0])+Integer.parseInt(Bminmax[0]);
		int max = Integer.parseInt(Aminmax[1])+Integer.parseInt(Bminmax[1]);
		
		System.out.println(min +" "+max);
		
	}

	public static String[] change(String num) {
		String[] minmax = {"", ""};
		
		for(int i=0;i<num.length();i++) {
			if(num.charAt(i)=='6') {
				minmax[0] = minmax[0] +"5";
			}else {
				minmax[0] = minmax[0] + num.charAt(i);
			}
			
			if(num.charAt(i)=='5') {
				minmax[1] = minmax[1] +"6";
			}else {
				minmax[1] = minmax[1] + num.charAt(i);
			}
		}
		return minmax;
	}
}
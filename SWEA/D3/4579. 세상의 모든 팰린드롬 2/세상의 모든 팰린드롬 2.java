import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();

			String[] arr = new String[s.length()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.charAt(i) + "";
			}
			boolean check = checkPalindrome(arr, s.length());
			if (check)
				sb.append("#" + test_case + " Exist\n");
			else
				sb.append("#" + test_case + " Not exist\n");
		}
		System.out.print(sb);
	}

	private static boolean checkPalindrome(String[] arr, int num) {// 문자열, 길이
		int cnt = 0;
		for (int i = 0; i < num / 2; i++) {
			if(arr[i].equals("*")||arr[num-i-1].equals("*")) return true;
			else if (!arr[i].equals(arr[num - i - 1]))
				return false;
		}
		return true;
	}
}
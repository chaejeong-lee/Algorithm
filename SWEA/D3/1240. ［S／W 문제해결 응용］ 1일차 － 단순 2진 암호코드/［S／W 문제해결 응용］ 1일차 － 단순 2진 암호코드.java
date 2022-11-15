import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	//암호 코드 앞에서 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	static String[] pw_code = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());//배열 입력 개수
			int M = Integer.parseInt(st.nextToken());//배열 가로 길이
			int[] decimalNum = new int[8];
			
			String str="";
			String sub="";
			String tmp="";
			int cnt=0;
			boolean isFind = false;
			
			for(int i=0;i<N;i++) {
				str = br.readLine();
				for(int j=M-1;j>= 0&& !isFind ;j--) {
					if(str.charAt(j)=='1') {
						sub = str.substring(j-55, j+1);//입력받은 줄에 1이 있으면 그것을 기준으로 56글자 가져오기
						isFind = true;//암호를 찾았음
					}
				}
			}
			
			for(int i =0;i<sub.length();i=i+7) {
				tmp = sub.substring(i, i+7);//앞에서부터 7글자씩 자르기 위해
				for(int j=0;j<pw_code.length;j++) {
					if(tmp.equals(pw_code[j])) {//자른 7글자 중에 pw_code에 해당하는 암호가 있는 지 확인
						decimalNum[cnt++]=j;//해당하는 암호와 동일한 경우 해당 숫자를 삽입
					}
				}
			}
			//암호코드가 10의 배수임을 확인하기 위한 부분
			int answer = (decimalNum[0]+decimalNum[2]+decimalNum[4]+decimalNum[6])*3+decimalNum[1]+decimalNum[3]+decimalNum[5]+decimalNum[7];
			
			if(answer%10==0&&answer>=10) {//10의 배수임을 확임, 1의 자리 숫자이면 안됨
				answer =0;
				for(int j=0;j<decimalNum.length;j++) {
					answer += decimalNum[j];//해당되는 숫자들을 모두 합해줌
				}
			}else {
				answer =0;
			}
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.print(sb);
	}
}
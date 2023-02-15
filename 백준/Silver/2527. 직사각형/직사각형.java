import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 4;//테스트 케이스
		
		for(int test_case = 0; test_case<T;test_case++) {
			int[][] rectangle = new int[2][4];//사각형 2개
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<rectangle.length;i++) {
				for(int j=0;j<rectangle[i].length;j++) {
					rectangle[i][j]= Integer.parseInt(st.nextToken()); 
				}
			}
			if(checkD(rectangle)) sb.append("d\n");
			else if(checkC(rectangle)) sb.append("c\n");
			else if(checkB(rectangle)) sb.append("b\n");
			else sb.append("a\n");
		}
		System.out.print(sb);
	}
	
	private static boolean checkB(int[][] rectangle) {//선분
		if(rectangle[0][2] == rectangle[1][0] || rectangle[0][3]==rectangle[1][1] || rectangle[1][2]==rectangle[0][0] || rectangle[0][1] == rectangle[1][3]) {
			return true;
		}
		return false;
	}
	
	private static boolean checkC(int[][] rectangle) {//점
		if((rectangle[0][2] == rectangle[1][0] && rectangle[0][3]==rectangle[1][1]) || (rectangle[0][2] == rectangle[1][0] && rectangle[0][1] == rectangle[1][3]) || (rectangle[0][0] == rectangle[1][2] && rectangle[0][1] == rectangle[1][3]) || (rectangle[0][0] == rectangle[1][2] && rectangle[0][3] == rectangle[1][1])) {
			return true;
		}
		return false;
	}

	private static boolean checkD(int[][] rectangle) {//공통 부분 없음
		if(rectangle[0][2]<rectangle[1][0] || rectangle[0][3]<rectangle[1][1] || rectangle[1][2]<rectangle[0][0] || rectangle[1][3]<rectangle[0][1]) {
			return true;
		}
		return false;
	}
}

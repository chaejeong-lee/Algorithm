import java.io.*;
import java.util.*;

public class Main {
    static int N,M, pack = Integer.MAX_VALUE, piece = Integer.MAX_VALUE, answer;
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //기타줄 브랜드 정보 저장
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            //패키지 및 낱개 최소값 구하기
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            piece = Math.min(piece, Integer.parseInt(st.nextToken()));
        }
        //낱개를 6개 살 때 패키지보다 싼지 확인
        if(piece * 6 <= pack)	//"낱개 최소값 × 6  ≤ 패키지 최소값" 확인
            answer = piece * N;	//기타줄 모두 낱개로 구매
        else{
            answer = (N/6) * pack;	//패키지 구매할 수 있을 때까지 구매
            if(N%6 * piece <= pack)	//남은 기타줄 패키지로 구매할지, 낱개로 구매할지 확인
                answer += (N%6) * piece;	//남은 기타줄 낱개로 구매
            else
                answer += pack;	//남은 기타줄 패키지로 구매
        }
        bw.write(answer + "");	//기타줄 구매한 금액 BufferedWriter저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}
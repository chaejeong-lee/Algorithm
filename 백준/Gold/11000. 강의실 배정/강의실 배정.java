import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * S에 시작해서 T에 끝나는 N개의 수업이 주어짐
 * N : 수업 종류
 * S, T : 시작 시간, 끝나는 시간
 */

class Lecture{
	int start;
	int end;
	
	Lecture(){}
	Lecture(int start,int end){
		this.start = start;
		this.end = end;
	}
}


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Lecture[] lectures = new Lecture[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lectures[i] = new Lecture(start, end);
		}
		
		//시작 시작을 기준으로 오름차순 정렬
		//시작 시간이 같을 경우, 종료 시간을 기준으로 오름 차순
		Arrays.sort(lectures, (o1, o2) ->
			o1.start == o2.start ? o1.end - o2.end : o1.start-o2.start
		);
		
		//우선순위 큐에는 종료시간만 들어감 -> 오름 차순으로 자동 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lectures[0].end);//정렬된 배열의 첫 번째 end값을 큐에 넣어준다. 
		
		//배열을 두 번째 값부터 순회하면서
		for(int i=1;i<N;i++) {
			//start가 pq의 peek()보다 작거나 같다면  
			if(pq.peek() <= lectures[i].start) {
				//pq에서 하나 뺀다. 
				pq.poll();
			}
			//순회하면서 , 현재 end 값을 새로 pq값에 넣어준다. 
			pq.offer(lectures[i].end);
		}
		
		//pq에 남아있는 데이터의 갯수가 필요한 강의실의 갯수
		bw.write(pq.size()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

}

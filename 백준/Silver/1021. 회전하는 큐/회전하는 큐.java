import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//수가 들어있는 배열
		Deque<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean check = true;
			while(check) {
				int idx = 0;//몇번째에 들어있는지 찾기 위한 것
				Iterator<Integer> iterator = q.iterator();
				while(iterator.hasNext()) {
					if(iterator.next() == num) {
						break;
					}
					idx++;
				}
				
				if(idx == 0) {
					q.pollFirst();//앞부분 빼기
					check = false;
				}
				else if(idx>q.size()/2) {
					q.addFirst(q.removeLast());
					cnt++;
				}else {
					q.addLast(q.removeFirst());
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
}

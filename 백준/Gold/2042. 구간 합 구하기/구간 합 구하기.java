import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SegmentTree{
	long tree[];		// 각 원소가 담길 트리
	int treeSize;		// 트리의 크기
	
	//생성자 : 세그먼트 트리의 배열 사이즈 정해줌
	public SegmentTree(int arrsize) {
		//트리의 높이 구하기
		//자바의 Math.log는 자연로그이므로 밑을 2로 나누는 효과를 위해 log(2)로 나누기
		int h = (int)Math.ceil(Math.log(arrsize)/Math.log(2));
		// 높이를 이용하여 배열 사이즈 구 하기
		this.treeSize = (int)Math.pow(2, h+1);
		//배열 생성
		tree = new long[treeSize];
	}
	
	/**
	 * @param arr : 원소 배열
	 * @param node : 현재 노드
	 * @param start : 현재 구간 배열 시작
	 * @param end : 현재 구간 배열 끝
	 * @return
	 */
	public long init(long[] arr, int node, int start, int end) {
		//배열의 시작과 끝이 같다면 leaf노드가 되므로 원소 배열 값 그대로 담아주기
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		//leaf노드가 아닐 경우, 자식 노드 합 담아주자
		return tree[node] = init(arr, node*2, start, (start+end)/2)+init(arr, node*2+1, (start+end)/2+1, end);
	}
	
	/**
	 * 데이터 변경
	 * @param node : 현재 노드 idx
	 * @param start : 배열의 시작
	 * @param end : 배열의 끝
	 * @param idx : 변경된 데이터의 idx
	 * @param diff : 원래 데이터 값과 변경 데이터 값의 차이
	 */
	public void update(int node, int start, int end, int idx, long diff) {
		//만약 변경할 index 값이 범위 바깥일 경우 확인 불필요
		if(idx<start || end < idx) return;
		
		//차를 저장해준다.
		tree[node] += diff;
		
		//leaf 노드가 아닐경우, 아래 자식들도 확인
		if(start != end) {
			update(node*2, start, (start+end)/2, idx, diff);
			update(node*2+1, (start+end)/2+1, end, idx, diff);
		}
	}
	
	/**
	 * 구간 합 구하기
	 * @param node : 현재 노드
	 * @param start : 배열의 시작
	 * @param end : 배열의 끝
	 * @param left : 원하는 누적합의 시작
	 * @param right : 원하는 누적합의 끝
	 * @return
	 */
	public long sum(int node, int start, int end, int left, int right) {
		// 범위를 벗어나게 되는 경우 더할 필요 없음
		if(left>end || right <start)
			return 0;
		
		// 범위 내 완전히 포함 시에는 더 내려가지 않고 바로 리턴
		if(left<=start && end <= right)
			return tree[node];
		
		// 그 외의 경우 좌/우측으로 지속 탐색 수행
		return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right); 
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());// 수의 개수
		int M = Integer.parseInt(st.nextToken());// 수의 변경이 일어나는 횟수
		int K = Integer.parseInt(st.nextToken());// 구간의 합을 구하는 횟수
		
		long[] arr = new long[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree stree = new SegmentTree(N);
		stree.init(arr, 1, 1, N);
		
		for(int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			//1 - 데이터 변경 명령어
			if(cmd == 1) {
				stree.update(1, 1, N, a, b-arr[a]);
				arr[a] = b;
			}
			//그 외 - 구간합 명령어
			else {
				sb.append(stree.sum(1, 1, N, a, (int)b)).append("\n");
			}
		}
		System.out.print(sb);
	}

}

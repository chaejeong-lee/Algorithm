import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		int v; //간선
		int cost;//가중치
		
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
	}
	
	static int V, E, K;
	static List<Node>[] list; // 인접리스트
	static int[] distance;// 결과 거리
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());//정점의 개수
		E = Integer.parseInt(st.nextToken());//간선의 개수
		
		K = Integer.parseInt(br.readLine());//시작 정점의 개수
		
		list = new ArrayList[V+1];
		distance = new int[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);//최솟값을 구해야하므로 MAX 값으로 초기화
		
		for(int i = 1;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
		}
		
		distance[K] = 0;//시작점 거리값
		
		dijkstra(K);//K번 시작
		
		for(int i=1;i<distance.length;i++) {
			if(distance[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void dijkstra(int start) {
		//pq를 사용하면 최소값 기준으로 들어가기 때문에 연산이 줄어든다, 
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		
		queue.add(new Node(start, 0));//탐색 시작점
		
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			int current = currentNode.v;
			
			if(check[current] == true) continue;
			
			check[current] = true;
			
			//탐색할 점에 연결된 정보기반으로 distance 갱신
			for(Node node : list[current]) {
				if(distance[node.v]> distance[current] + node.cost) {
					distance[node.v] = distance[current] + node.cost;
					queue.add(new Node(node.v, distance[node.v]));
				}
			}
		}
	}
}

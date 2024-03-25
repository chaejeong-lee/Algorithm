import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point> {
		int num, weight;

		public Point(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return weight - o.weight;
		}
	}

	private static int n, m, l; // n: 지역 개수, m: 수색 범위, l: 길의 개수
	private static int[] items; // items: 아이템의 개수
	private static ArrayList<Point>[] list;
	private static int[] dist; // dist: 최단거리
	private static boolean[] visited; // visited: 방문여부

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		items = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Point>();
		}

		for (int i = 1; i <= l; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[start].add(new Point(end, cost));
			list[end].add(new Point(start, cost));
		}
		

		dist = new int[n + 1];
		visited = new boolean[n + 1];

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, dijkstra(i));
		}
		System.out.println(answer);
	}

	private static int dijkstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(visited, false);

		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			int cusNum = cur.num;

			if (!visited[cusNum]) {
				visited[cusNum] = true;

				for (Point point : list[cusNum]) {
					if (!visited[point.num] && dist[point.num] > dist[cur.num] + point.weight) {
						dist[point.num] = dist[cur.num] + point.weight;
						pq.add(new Point(point.num, dist[point.num]));
					}
				}
			}
		}

		int answer = 0;
		
		for(int i=1;i<=n;i++) {
			if(dist[i]<=m) answer += items[i];
		}
		
		return answer;
	}
}
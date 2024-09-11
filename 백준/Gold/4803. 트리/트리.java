import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int testCase = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            graph = new ArrayList<>();
            for(int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < m; i++ ){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            visited = new boolean[n + 1];

            int count = 0;
            for(int i = 1; i < n + 1; i++) {
                if(!visited[i]) {
                    if(bfs(i)) count += 1;
                }
            }

            if(count == 0) {
                sb.append("Case " + testCase++ + ": No trees.");
            } else if(count == 1) {
                sb.append("Case " + testCase++ + ": There is one tree.");
            } else {
                sb.append("Case " + testCase++ + ": A forest of " + count + " trees.");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;
        int node = 0, edge = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            node += 1;
            visited[cur] = true;

            for(int next : graph.get(cur)) {
                edge += 1;
                if(!visited[next]) {
                    q.add(next);
                }
            }
        }

        return 2*(node-1) == edge ? true : false;
    }
}
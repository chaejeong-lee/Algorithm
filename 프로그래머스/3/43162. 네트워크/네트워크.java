class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0;i<computers.length;i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    
    public void dfs(int cur, int[][] computers) {
        visited[cur] = true;
        
        for(int i=0;i<computers[cur].length;i++) {
            if(visited[i] == false && computers[cur][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
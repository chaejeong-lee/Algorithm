import java.util.*;

class Solution {
    ArrayList<String> candi = new ArrayList<>();
    
    public int solution(String[][] relation) {
        for (int i = 0; i < relation[0].length; i++) {
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited, 0, 0, i + 1, relation);
        }
        return candi.size();
    }
    
    public void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            List<Integer> list = new ArrayList<>();
            String key = "";
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }

            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < relation.length; i++) {
                String s = "";
                for (Integer j : list) {
                    s += relation[i][j];
                }

                if (map.containsKey(s)) {
                    return;
                } else {
                    map.put(s, 0);
                }
            }

            // 후보키 추가
            for (String s : candi) { 
                int count = 0;
                for(int i = 0; i < key.length(); i++){
                    String subS = String.valueOf(key.charAt(i));
                    if(s.contains(subS)) count++;
                }
                if (count == s.length()) return;
            }
            candi.add(key);

            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(visited, i, depth + 1, end, relation);
            visited[i] = false;
        }

    }
}
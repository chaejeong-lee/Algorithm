import java.util.*;

class Solution {
    public class Album implements Comparable<Album> {
        int idx, point;
        
        public Album(int idx, int point) {
            this.idx = idx;
            this.point = point;
        }
        
        @Override
        public int compareTo(Album a) {
            if(a.point == this.point) return this.idx - a.idx;
            return a.point - this.point;
        }
    }
    
    public class Genre {
        int total;
        PriorityQueue<Album> pq;
        
        public Genre(int total) {
            this.total = total;
            pq = new PriorityQueue<>();
        }
        
        public void add(int point) {
            total += point;
        }
    }
    public List<Integer> solution(String[] genres, int[] plays) {
        HashMap<String, Genre> hm = new HashMap<>();
        for(int i = 0; i<genres.length;i++) {
            if(!hm.containsKey(genres[i])) {
                hm.put(genres[i], new Genre(plays[i]));
            }
            else {
                hm.get(genres[i]).add(plays[i]);
            }
            hm.get(genres[i]).pq.add(new Album(i, plays[i]));
        }
        
        List<Map.Entry<String, Genre>> list = new ArrayList<>(hm.entrySet());
        list.sort((e1, e2) -> {
            return e2.getValue().total - e1.getValue().total;
        });
        
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<list.size();i++) {
            int s = list.get(i).getValue().pq.size();
            for(int j=0;j<s;j++) {
                if(j == 2) {
                    break;
                }
                Album cur = list.get(i).getValue().pq.poll();
                answer.add(cur.idx);
            }
        }
        return answer;
    }
}
class Solution {
    int[][] map;
    int startR = 0, startC = 0;
    
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[] solution(String[] park, String[] routes) {
        map = new int[park.length][park[0].length()];
        
        for(int i=0;i<park.length;i++) {
            for(int j=0;j<park[i].length();j++) {
                if(park[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                }
                else if(park[i].charAt(j) == 'X') {
                    map[i][j] = 1;
                }
            }
        }
        
        // 방향에 따라 이동 시작
        for(int i=0;i<routes.length;i++) {
            char d = routes[i].charAt(0);
            int cnt = routes[i].charAt(2) - '0';
            
            int dd = 0;
            if(d == 'S') dd = 1;
            else if(d == 'W') dd = 2;
            else if(d == 'E') dd = 3;
            else dd = 0;
            moveMap(dd, cnt);
        }
        
        return new int[] {startR, startC};
    }
    
    public void moveMap(int d, int cnt) {
        int nextR = startR;
        int nextC = startC;
        for(int i = 0; i<cnt;i++) {
            nextR += dir[d][0];
            nextC += dir[d][1];
            
            if(!isRange(nextR, nextC)) return;
            if(map[nextR][nextC] == 1) return;
            
        }
        startR = nextR;
        startC = nextC;
    }
    
    public boolean isRange(int r, int c) {
        return 0 <= r && r < map.length && 0 <= c && c < map[0].length;
    }
}
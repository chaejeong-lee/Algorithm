import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Point
{
    int x,y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Main {
	
    static int N,M,T;
    static List<Integer>[] map;
    static int [] mv;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new List[N+1];
        mv = new int[4];

        //상 하 좌 우
        mv[0] = 1;
        mv[1] = -1;
        mv[2] = 1;
        mv[3] = M - 1;

        for(int i = 0; i <= N; ++i) map[i] = new LinkedList<>();

        for(int i = 1; i <= N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j){
                map[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < T; ++i){
            st = new StringTokenizer(br.readLine());
            rotate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        
        int answer = 0;
        for(List<Integer> i : map){
            for(int j : i){
                answer += j;
            }
        }
        System.out.print(answer);
	}


    static void rotate(int x, int d, int k){
        int len = k;
        if(d == 0) len = M - k;

        for(int i = x; i <= N; i+=x){
            List<Integer> tmp_list = map[i].subList(0,len);
            map[i].addAll(tmp_list);
            map[i].subList(0,len).clear();
        }
        check();
    }
    
    static void check(){
        int total = 0;
        int cnt = 0;
        boolean flag = false;
        Set<Point> set = new HashSet<>();
        
        for(int i = 1; i <= N; ++i){
            for(int j = 0; j < M; ++j){
                int cur = map[i].get(j);
                if(cur > 0){
                    total += cur;
                    cnt++;
                    for(int idx = 0; idx < 2; ++idx) {
                        int mx = i + mv[idx];

                        if(!isValid(mx) || map[mx].get(j) < 1) continue;
                        if(cur == map[mx].get(j)){
                            flag = true;
                            set.add(new Point(i,j));
                            set.add(new Point(mx,j));
                        }
                    }

                    for(int idx = 2; idx < 4; ++idx){
                        int my = (j + mv[idx]) % M;
                        if(map[i].get(my) > 0){
                            if(cur == map[i].get(my)){
                                flag = true;
                                set.add(new Point(i,j));
                                set.add(new Point(i,my));
                            }
                        }
                    }
                }
            }
        }
        
        if(!flag) {
            double ave = (double)total/cnt;
            for(int i = 1; i <= N; ++i) {
                for(int j = 0; j < M; ++j) {
                    int cur = map[i].get(j);
                    if(cur > 0) {
                        if(cur > ave) map[i].set(j,cur-1);
                        else if(cur < ave) map[i].set(j,cur+1);
                    }
                }
            }
        }
        else {
            for(Point cur : set) {
                map[cur.x].set(cur.y,0);
            }
        }

    }
    

    static boolean isValid(int x) {
        return x > 0 && x <= N;
    }
}

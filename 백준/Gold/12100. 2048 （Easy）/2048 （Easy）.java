import static java.util.Arrays.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int[][] map;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        } // end input

        rotate(0);
        System.out.println(ans);
    }

    private static void rotate(int count) { // dfs

        if(count==5){ // 5번 움직였을 때 종결
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    ans = Math.max(ans,map[i][j]); // max 값 갱신
            return;
        }

        int[][] nextMap = new int[n][n]; // 이전 상태로 되돌리기 위한 배열 복사
        for(int k=0;k<n;k++)
            nextMap[k] = map[k].clone();

        for(int i=0;i<4;i++){ // 우,좌,하,상
            move(i);
            rotate(count+1);
            for(int k=0;k<n;k++)
                map[k] = nextMap[k].clone(); // 원복
        }
    }

    static void move(int dir) { // 해당 방향에서 움직이는 함수

        LinkedList<Integer> q = new LinkedList<>(); // 한번 움직임에 두 번 이상 합쳐짐을 방지하기 위한 큐

        if (dir == 0) { // 우
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0)
                        q.add(map[i][j]); // 큐에 삽입
                    map[i][j] = 0;
                }

                int index = 0; // 0부터 시작
                while (!q.isEmpty()) {
                    Integer cur = q.poll();

                    if (map[i][index] == 0) { // 0 이면
                        map[i][index] = cur;
                    } else if (map[i][index] == cur) { // 병합하기
                        map[i][index] = cur * 2;
                        index++;
                    } else { // 합쳐질 수 없는 경우 그대로 이동만
                        index++;
                        map[i][index] = cur;
                    }
                }
            }
        } else if (dir == 1) { // 좌
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (map[i][j] != 0)
                        q.add(map[i][j]);
                    map[i][j] = 0;
                }

                int index = n - 1;
                while (!q.isEmpty()) {
                    Integer cur = q.poll();

                    if (map[i][index] == 0) {
                        map[i][index] = cur;
                    } else if (map[i][index] == cur) {
                        map[i][index] = cur * 2;
                        index--;
                    } else {
                        index--;
                        map[i][index] = cur;
                    }
                }
            }
        } else if (dir == 2) { // 하
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (map[j][i] != 0)
                        q.add(map[j][i]);
                    map[j][i] = 0;
                }

                int index = n - 1;
                while (!q.isEmpty()) {
                    Integer cur = q.poll();

                    if (map[index][i] == 0) {
                        map[index][i] = cur;
                    } else if (map[index][i] == cur) {
                        map[index][i] = cur * 2;
                        index--;
                    } else {
                        index--;
                        map[index][i] = cur;
                    }
                }
            }
        } else if (dir == 3) { // 상
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[j][i] != 0)
                        q.add(map[j][i]);
                    map[j][i] = 0;
                }

                int index = 0;
                while (!q.isEmpty()) {
                    Integer cur = q.poll();

                    if (map[index][i] == 0) {
                        map[index][i] = cur;
                    } else if (map[index][i] == cur) {
                        map[index][i] = cur * 2;
                        index++;
                    } else {
                        index++;
                        map[index][i] = cur;
                    }
                }
            }
        }
    }
}
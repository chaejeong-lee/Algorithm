import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int gearCount = Integer.parseInt(reader.readLine());
        Gear[] gears = new Gear[gearCount];

        for (int i = 0; i < gearCount; i++) 
            gears[i] = new Gear(Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray());

        int rollCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < rollCount; i++) {
            String[] input = reader.readLine().split(" ");
            int pos = Integer.parseInt(input[0]) - 1;
            int direction = Integer.parseInt(input[1]); // 1 : 시계 방향, -1 : 반시계 방향
            int[] roll = new int[gearCount];

            // 현 위치를 회전시킴
            roll[pos] = direction;

            // 왼쪽 순회
            for (int j = pos - 1; j > -1; j--) {
                Gear current = gears[j];
                Gear prev = gears[j + 1];
            
                if (prev.get9() == current.get3()) 
                    break;
                else {
                    roll[j] = -1 * roll[j + 1]; // 반대 방향으로 회전
                }
            }

            // 오른쪽 순회
            for (int j = pos + 1; j < gearCount; j++) {
                Gear current = gears[j];
                Gear prev = gears[j - 1];

                if (prev.get3() == current.get9()) {
                    break;
                } else {
                    roll[j] = -1 * roll[j - 1];
                }
            }

            // 실제 회전
            for (int j = 0; j < gearCount; j++) {
                if (roll[j] == 1) gears[j].rollRight();
                if (roll[j] == -1) gears[j].rollLeft();
            }
        }

        int count = 0;
        for (int i = 0; i < gearCount; i++)
            if (gears[i].get12() == 1)
                count += 1;

        System.out.println(count);        
    }  
}

class Gear {
    private int[] gear;
    private int currentPos;

    public Gear(int[] array) {
        gear = array;
        currentPos = 0;
    }

    public void rollLeft() {
        currentPos = (currentPos + 1) % 8;
    }

    public void rollRight() {
        if (currentPos == 0) currentPos = 7;
        else currentPos -= 1;
    }

    public int get12() {
        return gear[currentPos];
    }

    public int get3() {
        return gear[(currentPos + 2) % 8];
    }

    public int get9() {
        return gear[(currentPos + 6) % 8];
    }
}
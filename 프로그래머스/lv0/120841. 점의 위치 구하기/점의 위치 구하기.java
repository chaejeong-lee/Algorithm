class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        if(dot[0]>0 &&dot[1]>0){//1사분면(x양수, y 양수)
            answer = 1;
        }else if(dot[0]<0 && dot[1]>0){//2사분면 (x 음수, y 양수)
            answer = 2;
        }else if(dot[0]<0 && dot[1]<0){//3사분면(x음수, y 음수)
            answer = 3;
        }else if(dot[0]>0 && dot[1]<0){//4사분면 (x양수, y 음수)
            answer = 4;
        }
        return answer;
    }
}
class Solution {
    public long solution(int price, int money, int count) {
        //원래 이용료(price) 놀이기구 사용 n번(count) n배 받음
        long answer = money;
        for(int i=1;i<=count;i++){
            answer -= price*i;
        }
        if(answer<0){
            answer = Math.abs(answer);
        }else{
            answer = 0;
        }
        return answer;
    }
}
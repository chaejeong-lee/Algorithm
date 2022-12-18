class Solution {
    public int solution(String s) {
        int answer = 0;
        char c = s.charAt(0);
        if(c=='-'){//음수일 경우
            String cut = s.substring(1);
            answer = -Integer.parseInt(cut);
        }else{//음수 부호가 없는 경우
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}
class Solution {
    public String solution(int age) {
        String answer = "";
        String s = String.valueOf(age);//int age를 문자로 바꿔주기
        String[] arr = s.split("");//공백을 기준으로 한자리마다 자르기
        for(int i=0;i<arr.length;i++){
            answer += ((char)(Integer.parseInt(arr[i])+97));
        }
        return answer;
    }
}
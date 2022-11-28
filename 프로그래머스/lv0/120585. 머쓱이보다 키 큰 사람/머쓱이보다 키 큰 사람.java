import java.util.Arrays;
class Solution {
    public int solution(int[] array, int height) {//array: 키가 담긴 정수 배열, height : 머쓱이의 키
        int answer = 0;
        
        Arrays.sort(array);
        for(int i=0;i<array.length;i++){
            if(array[i]>height){
                answer = array.length-i;
                break;
            }
        }
        
        return answer;
    }
}
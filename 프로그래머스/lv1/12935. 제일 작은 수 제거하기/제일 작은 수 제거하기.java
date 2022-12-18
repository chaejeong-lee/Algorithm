import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] remo = arr.clone();
        Arrays.sort(remo);
        int min = remo[0];
        
        ArrayList<Integer> arli = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] != min){
                arli.add(arr[i]);
            }
        }
        
        int[] answer;
        if(arli.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[arli.size()];
            for(int i=0;i<answer.length;i++){
                answer[i] = arli.get(i);
            }
        }
        return answer;
    }
}
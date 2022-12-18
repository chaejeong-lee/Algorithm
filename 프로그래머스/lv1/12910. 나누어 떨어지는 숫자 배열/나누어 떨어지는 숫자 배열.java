import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        int check =0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                arrlist.add(arr[i]);
            }
        }
        if(arrlist.isEmpty()){
            arrlist.add(-1);
        }
        
        int[] answer = new int[arrlist.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = arrlist.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
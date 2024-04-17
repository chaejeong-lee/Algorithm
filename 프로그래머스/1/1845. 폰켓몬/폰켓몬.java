import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], 1);
            }else{
                hm.put(nums[i], hm.get(nums[i]++));
            }
        }
        
        int answer = hm.size()>nums.length/2? nums.length/2:hm.size();
        
        return answer;
    }
}
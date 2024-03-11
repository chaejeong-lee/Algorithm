class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        solution(numbers, target, 1, -numbers[0]);
        solution(numbers, target, 1, numbers[0]);
        return answer;
    }
    
    private void solution(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(sum == target) answer++;
            return;
        }
        
        solution(numbers, target, idx+1, sum + numbers[idx]);
        solution(numbers, target, idx+1,sum - numbers[idx]);
    }
}
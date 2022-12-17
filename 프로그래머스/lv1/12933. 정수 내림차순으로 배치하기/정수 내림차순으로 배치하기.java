class Solution {
    public long solution(long n) {
        String answer = "";
        String s = Long.toString(n);//long n을 문자열로 변환
        int[] arr = new int[s.length()];//s로 변환
        
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(s.substring(i, i+1));
        }
        
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]<arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        
        for(int i=0;i<arr.length;i++){
            answer += arr[i];
        }
        
        return Long.parseLong(answer);
    }
}
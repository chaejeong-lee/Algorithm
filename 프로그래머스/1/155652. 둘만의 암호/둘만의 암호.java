class Solution {
    public String solution(String s, String skip, int index) {
    	// 변환된 문자열을 저장하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 문자열 s 순회
        for (char ch : s.toCharArray()) {
            // 변환 횟수 기록하기 위한 count
            int count = 0;
            
            // index 크기 만큼 순회하여 변환
            while (count < index) {
            	// 현재 문자 ch가 z이면 a로 변환, 아니면 다음 문자로 변환
                if (ch == 'z') {
                    ch = 'a';
                } else {
                    ch++;
                }

                // 현재 문자가 skip 문자열에 포함되지 않는 경우
                if (!skip.contains(String.valueOf(ch))) {
                    count++;
                }
            }
            // 변환된 문자 sb에 추가
            sb.append(ch);
        }
        return sb.toString();
    }
}
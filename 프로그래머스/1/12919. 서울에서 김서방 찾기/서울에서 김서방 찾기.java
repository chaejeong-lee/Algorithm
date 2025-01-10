import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String[] seoul) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(seoul));
        return "김서방은 " + list.indexOf("Kim") + "에 있다";
    }
}
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        
        Arrays.sort(arr);
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
        	answer += arr[arr.length - 1 - i];
        }
        return answer;
    }
}
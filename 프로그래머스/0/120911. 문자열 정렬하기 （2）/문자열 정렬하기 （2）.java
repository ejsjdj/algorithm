import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String answer = my_string.toLowerCase();
        String[] my_string_arr = answer.split("");
        Arrays.sort(my_string_arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < my_string_arr.length; i++) {
        	stringBuilder.append(my_string_arr[i]);
        }
        
        answer = stringBuilder.toString();
        return answer;
    }
}
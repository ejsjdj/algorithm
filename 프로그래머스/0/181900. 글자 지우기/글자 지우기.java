import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        char[] arr = my_string.toCharArray();
        Arrays.sort(indices);

        List<Character> list = new ArrayList<>();
        for (char c : arr) {
            list.add(c);
        }
        
        for(int i=indices.length - 1; i >= 0; i--) {
            list.remove(indices[i]);
        }

        for(int i = 0; i < list.size(); i++) {
            answer += "" + list.get(i);
        }


        return answer;
    }
}
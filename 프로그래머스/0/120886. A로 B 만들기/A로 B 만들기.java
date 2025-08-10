import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {

        String[] before_arr = before.split("");
        String[] after_arr = after.split("");
        
        Arrays.sort(before_arr);
        Arrays.sort(after_arr);
        
        for (int i = 0; i < before_arr.length; i++) {
        	if (!before_arr[i].equals(after_arr[i])) return 0;
        }
        return 1;
    }
}
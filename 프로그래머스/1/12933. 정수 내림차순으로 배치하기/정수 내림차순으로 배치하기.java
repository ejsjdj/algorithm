import java.util.Arrays;


class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        String[] s_arr = new String[s.length()];
        
        for (int i = 0; i < s_arr.length; i++) {
        	s_arr[i] = String.valueOf(s.charAt(i));
        }
        Arrays.sort(s_arr);
        
        for (int i = 0; i < s_arr.length; i++) {
        	answer = answer * 10 + Long.parseLong(s_arr[s_arr.length - i - 1]);
        }
        
        return answer;
    }
}
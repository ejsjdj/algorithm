import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] s_arr = s.split(" ");
        
        int[] arr= new int[s_arr.length];
        
        for (int i = 0; i < arr.length; i++) { 
        	arr[i] = Integer.parseInt(s_arr[i]);
        }
        
        Arrays.sort(arr);
        
        answer += String.valueOf(arr[0]) + " ";
        answer += String.valueOf(arr[arr.length-1]);
        
        return answer;
    }
}
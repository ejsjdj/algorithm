import java.util.Arrays;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        int[] arr = new int[1001];
        for (int i = 0; i < arr.length; i++) {
        	arr[i] = 0;
        }
        
        for (int i = 0; i < strArr.length; i++) {
        	arr[strArr[i].length()] += 1;
        }
        
        Arrays.sort(arr);
        
        answer = arr[arr.length-1];
        
        return answer;
    }
}
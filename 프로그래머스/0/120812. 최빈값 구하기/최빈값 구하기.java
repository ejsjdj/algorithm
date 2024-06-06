import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        
        int cnt = 0;
        int max = -1;
        int maxCnt = 0;
        
        if (array.length == 1) return array[0];
        
        for (int i = 1; i < array.length; i++) {
        	if (array[i] == array[i-1]) {
        		cnt += 1;
        		if (cnt == maxCnt) {
        			max = -1;
        		} else if (cnt > maxCnt) {
        			max = array[i];
        			maxCnt = cnt;
        		}
        	} else {
        		cnt = 0;
        	}
        }
        
        return max;
    }
}
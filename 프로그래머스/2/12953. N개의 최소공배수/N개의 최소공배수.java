import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
    	Arrays.sort(arr);
        int i = arr[arr.length - 1];
        while (true) {
        	boolean flag = true;
        	for (int n : arr) {
        		if (i % n != 0) {
        			flag = false;
        			break;
        		}
        	}
        	if (flag == true) return i;
        	else i++;
        }
    }
}
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String X, String Y) {
    	StringBuilder answer = new StringBuilder();

        
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        int[] arrZ = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
        	arrX[X.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
        	arrY[Y.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < arrZ.length; i++) {
        	arrZ[i] = Math.min(arrX[i], arrY[i]);
        }
        
        for (int i = 9; i >= 0; i--) {
        	while (arrZ[i] > 0) {
        		answer.append(i);
        		arrZ[i]--;
        	}
        }
        
        if (answer.length() == 0) return "-1";
        if (answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}
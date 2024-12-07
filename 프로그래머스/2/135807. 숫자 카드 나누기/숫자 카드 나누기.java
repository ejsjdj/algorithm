import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        
        for (int i = 2; i <= arrayA[0]; i++) {
        	boolean flag = true;
        	for (int j = 0; j < arrayA.length; j++) {
        		if (arrayA[j] % i != 0) {
        			flag = false;
        			break;
        		}
        	}
        	if (flag) {listA.add(i);}
        }
        
        for (int i = 2; i <= arrayB[0]; i++) {
        	boolean flag = true;
        	for (int j = 0; j < arrayA.length; j++) {
        		if (arrayB[j] % i != 0) {
        			flag = false;
        			break;
        		}
        	}
        	if (flag) {listB.add(i);}
        }
        
        for (int i = 0; i < listA.size(); i++) {
        	int A = listA.get(i);
        	boolean flag = true;
        	for (int j = 0; j < arrayB.length; j++) {
        		if (arrayB[j] % A == 0) {
        			flag = false;
        			break;
        		}
        	}
        	if (flag) {
        		if (answer < A) answer = A;
        	}
        }
        
        for (int i = 0; i < listB.size(); i++) {
        	int B = listB.get(i);
        	boolean flag = true;
        	for (int j = 0; j < arrayA.length; j++) {
        		if (arrayA[j] % B == 0) {
        			flag = false;
        			break;
        		}
        	}
        	if (flag) {
        		if (answer < B) answer = B;
        	}
        }
        
        return answer;
    }
}
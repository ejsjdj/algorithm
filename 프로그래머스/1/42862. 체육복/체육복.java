import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n];
        Arrays.fill(student, 1);
        
        // 체육복이 없는 학생은 0으로 만듬
    	for (int c : lost) {
    		student[c-1] = 0;
    	}
    	
    	// 체육복이 있는 학생은 +1을 함
    	for (int c : reserve) {
    		student[c-1] += 1;
    	}
        if (student[0] == 0 && student[1] == 2) {
        	student[1] = 1;
        	student[0] = 1;
        }
    	for (int i = 1; i < student.length - 1; i++) {
    		if (student[i] == 0) {
    			if (student[i - 1] == 2) {
    				student[i] = 1;
    				student[i - 1] = 1;
    			}
    			else if (student[i + 1] == 2) {
    				student[i] = 1;
    				student[i + 1] = 1;
    			}
    		}
    	}
    	if (student[student.length - 1] == 0 && student[student.length - 2] == 2) {
        	student[student.length - 1] = 1;
        	student[student.length - 2] = 1;
        }
        
    	for (int i = 0; i < student.length; i++) {
    		if (student[i] >= 1) answer++;
    	}
    	
        return answer;
    }
}
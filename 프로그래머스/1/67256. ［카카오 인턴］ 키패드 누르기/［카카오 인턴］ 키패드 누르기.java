class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left = 10;
        int right = 12;
        
        for (int i = 0; i < numbers.length; i++) {
        	if (numbers[i] == 0) numbers[i] = 11;
        }
        
        for (int i = 0; i < numbers.length; i++) {
        	int now = numbers[i];
        	if (now == 1 || now == 4 || now == 7) {
        		answer += "L";
        		left = numbers[i];
        	} else if (now == 3 || now == 6 || now == 9) {
        		answer += "R";
        		right = numbers[i];
        	} else {
        		if (left == numbers[i]) {
        			answer += "L";
        		} else if (right == numbers[i]) {
        			answer += "R";
        		} else {
        			int ldif; // 0, 5, 8, 2
        			int rdif;
        			int lcnt = 0;
        			int rcnt = 0;
        			if (left < numbers[i]) {
        				ldif = numbers[i] - left;
        			} else {
        				ldif = left - numbers[i];
        			}
        			
        			if (right < numbers[i]) {
        				rdif = numbers[i] - right;
        			} else {
        				rdif = right - numbers[i];
        			}
        			
        			if (ldif == 1 || ldif == 3) {
        				lcnt = 1;
        			} else if (ldif == 2 || ldif == 4 || ldif == 6) {
        				lcnt = 2;
        			} else if (ldif == 5 || ldif == 7 || ldif == 9) {
        				lcnt = 3;
        			} else if (ldif == 8|| ldif == 10) {
        				lcnt = 4;
        			}
        			
        			if (rdif == 1 || rdif == 3) {
        				rcnt = 1;
        			} else if (rdif == 2 || rdif == 4 || rdif == 6) {
        				rcnt = 2;
        			} else if (rdif == 5 ||rdif == 7 || rdif == 9) {
        				rcnt = 3;
        			} else if (rdif == 8 || rdif == 10) {
        				rcnt = 4;
        			}
        			
        			if (lcnt < rcnt) {
        				answer += "L";
        				left = now;
        			} else if (lcnt > rcnt) {
        				answer += "R";
        				right = now;
        			} else {
        				if (hand.equals("right")) {
        					answer += "R";
        					right = now;
        				} else {
        					answer += "L";
        					left = now;
        				}
        			}
        		}
        	}
        }
        
        return answer;
    }
}

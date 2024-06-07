class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
        	String[] arr = quiz[i].split(" ");
        	if (arr[1].equals("+")) {
        		if (Integer.parseInt(arr[4]) == Integer.parseInt(arr[0]) + Integer.parseInt(arr[2])) {
        			answer[i] = "O";
        		} else answer[i] = "X";
        	} else if (arr[1].equals("-")) {
        		if (Integer.parseInt(arr[4]) == Integer.parseInt(arr[0]) - Integer.parseInt(arr[2])) {
        			answer[i] = "O";
        		} else answer[i] = "X";
        	}
        }
        return answer;
    }
}
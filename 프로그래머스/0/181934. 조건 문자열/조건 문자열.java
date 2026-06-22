class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        boolean flag = false;
        if (ineq.equals("<") && eq.equals("=")) {
        	flag = n <= m ? true : false;
        } else if (ineq.equals(">") && eq.equals("=")) {
        	flag = n >= m ? true: false;
        } else if (ineq.equals("<") && eq.equals("!")) {
        	flag = n < m ? true : false;
        } else if (ineq.equals(">") && eq.equals("!")) {
        	flag = n > m ? true : false;
        }
        
        answer = flag == true ? 1 : 0;
        
        return answer;
    }
}
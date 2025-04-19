import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = calc(p);
        return answer;
    }
    
    String calc(String p) {
    	if (p.isEmpty()) return "";
    	
    	String u = "";
    	String v = "";
    	int cnt1 = 0;
    	int cnt2 = 0;
    	for (int i = 0; i < p.length(); i++) {
    		if (p.charAt(i) == '(') cnt1++;
    		else if (p.charAt(i) == ')') cnt2++;
    		if (cnt1 == cnt2) {
    			u = p.substring(0, i + 1);
    			v = p.substring(i + 1, p.length());
    			break;
    		}
    	}
    	
    	Stack<Character> stack = new Stack<>();
    	boolean flag = true;
    	for (int i = 0; i < u.length(); i++) {
    		if (u.charAt(i) == '(') stack.push('(');
    		else if (u.charAt(i) == ')' && !stack.isEmpty())  stack.pop();
    		else {
    			flag = false;
    			break;
    		}
    	}
    	
    	if (flag) u = u + calc(v); 
    	else {
    		String c = "(";
    		c += calc(v);
    		c += ')';
    		u = u.substring(1, u.length() - 1);
    		for (int i = 0; i < u.length(); i++) {
    			if (u.charAt(i) == '(') c += ')';
    			else c += '(';
    		}
    		u = c;
    	}
    	
    	return u;
    }
}
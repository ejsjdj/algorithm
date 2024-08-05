import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
        	stack.add(ingredient[i]);
        	
        	if (stack.size() >= 4) {
        		if (stack.get(stack.size() - 1) == 1 && stack.get(stack.size() - 2) == 3 && stack.get(stack.size() - 3) == 2 && stack.get(stack.size() - 1) == 1)  {
        			answer += 1;
        			stack.pop();
        			stack.pop();
        			stack.pop();
        			stack.pop();
        		}
        	}
        }
        return answer;
    }
}
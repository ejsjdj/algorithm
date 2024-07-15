import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
        	int num = numbers[i];
        	while (!stack.isEmpty() && stack.peek() <= num) {
        		stack.pop();
        	}
        	if (stack.isEmpty()) {
        		answer[i] = -1;
        		stack.add(num);
        	}
        	else {
        		answer[i] = stack.peek();
        		stack.add(num);
        	}
        }
        
        return answer;
    }
}
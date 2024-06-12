import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        Arrays.sort(routes, (o1, o2) -> o2[1] - o1[1]);
        
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < routes.length; i++) {
        	stack.add(routes[i]);
        }
        
        while (!stack.isEmpty()) {
        	if (camera >= stack.peek()[0]) {
        		stack.pop();
        	} else {
        		camera = stack.pop()[1];
        		answer += 1;
        	}
        }
        return answer;
    }
}
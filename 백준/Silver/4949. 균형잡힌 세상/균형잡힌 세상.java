import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            
            String str = bf.readLine();
            if (str.equals(".")) break; // 종료조건 
            
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            
            for (int i = 0; i < str.length(); i++) {
            	if (str.charAt(i) == '(' || str.charAt(i) == '[') stack.push(str.charAt(i));
            	
            	else if (str.charAt(i) == ')') {
            		if (stack.isEmpty() || stack.pop() != '(') {
            			flag = false;
            			break;
            		}
            	}
            	
            	else if (str.charAt(i) == ']') {
            		if (stack.isEmpty() || stack.pop() != '[') {
            			flag = false;
            			break;
            		}
            	}
            }
            if (flag && stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
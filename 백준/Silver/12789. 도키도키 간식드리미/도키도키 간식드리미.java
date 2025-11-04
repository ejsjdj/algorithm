import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int target = 1; // 현재 받아야 할 번호표
        
        for (int i = 0; i < n; i++) {
            int student = Integer.parseInt(st.nextToken());
            
            // 현재 학생을 스택에 추가
            stack.push(student);
            
            // 스택의 맨 위 학생이 받을 차례라면 계속 빼기
            while (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                target++;
            }
        }
        
        // 스택이 비어있으면 모든 학생이 순서대로 받을 수 있음
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}

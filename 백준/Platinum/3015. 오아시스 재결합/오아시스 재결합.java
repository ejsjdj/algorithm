import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Person {
    int count;
    int height;

    public Person(int count, int height) {
        this.count = count;
        this.height = height;
    }

}

public class Main {

    static Stack<Person> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        int[] person = new int[N];
        for (int i = 0; i < N; i++) {
            person[i] = Integer.parseInt(br.readLine());
        }

        long cnt = 0;

        for (int i = 0; i < N; i++) {
            // 스택에 값이 없으면 비운다.
            int current = person[i];
            int len = 1;
            if (stack.isEmpty()) {
                stack.push(new Person(len, current));
            }
            else {
                while (!stack.isEmpty()) {
                    if (stack.peek().height > current) {
                        cnt += 1;
                        break;
                    } else if (stack.peek().height == current) {
                        cnt += stack.peek().count;
                        len = stack.peek().count + 1;
                        stack.pop();
                    } else {
                        cnt += stack.peek().count;
                        stack.pop();
                    }
                }
                stack.push(new Person(len, current));
            }
        }
        System.out.println(cnt);
    }
}
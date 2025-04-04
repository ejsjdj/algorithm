import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] buildings = new int[n][2];
        for (int i = 0; i < n; i++) {
            buildings[i][0] = sc.nextInt(); // x좌표
            buildings[i][1] = sc.nextInt(); // y좌표
        }

        // x 좌표 기준 정렬
        Arrays.sort(buildings, (a, b) -> a[0] - b[0]);

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            if (y == 0) { // 빌딩이 사라질 때
                ans += stack.size();
                stack.clear(); // 스택 초기화
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > y) { // 스택의 top이 더 높은 경우
                stack.pop();
                ans++;
            }

            if (stack.isEmpty() || stack.peek() < y) { // 스택이 비어있거나 top이 낮은 경우
                stack.push(y);
            }
        }

        System.out.println(ans + stack.size());
        sc.close();
    }
}
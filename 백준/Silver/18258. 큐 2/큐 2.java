import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        int last = -1; // 마지막으로 삽입된 값을 저장할 변수
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String order = st.nextToken();
            
            if (order.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                queue.add(last);
            } else if (order.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else if (order.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (order.equals("empty")) {
                sb.append(queue.isEmpty() ? "1\n" : "0\n");
            } else if (order.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            } else if (order.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(last).append("\n"); // 마지막 삽입된 값 출력
                }
            }
        }
        
        System.out.print(sb); // 최종적으로 한 번에 출력
    }
}
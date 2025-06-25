import java.io.*;
import java.util.*;

public class Main {
    static class Balloon {
        int index, value;
        Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            deque.addLast(new Balloon(i, value));
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            Balloon now = deque.removeFirst();
            sb.append(now.index).append(" ");
            if (deque.isEmpty()) break;

            int move = now.value;
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    deque.addFirst(deque.removeLast());
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
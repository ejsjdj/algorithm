import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            int index = i;

            while  (!deque.isEmpty() && deque.getLast().value > value) {
                deque.removeLast();
            }

            deque.addLast(new Node(value, index));

            while (!deque.isEmpty() && deque.getFirst().index < index - L + 1) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }
}
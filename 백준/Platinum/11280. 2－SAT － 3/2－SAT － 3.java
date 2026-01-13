import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Graph {
    List<Integer> list;

    public Graph() {
        list = new ArrayList<>();
    }
}

public class Main {

    static Graph[] graphs;
    static int[] d;
    static Stack<Integer> stack;
    static boolean[] visited;
    static boolean[] finished;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graphs = new Graph[2 * N + 1];
        d = new int[2 * N + 1];
        stack = new Stack<>();
        visited = new boolean[2 * N + 1];
        finished = new boolean[2 * N + 1];

        for (int i = 1; i < graphs.length; i++) {
            graphs[i] = new Graph();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 만약에 a 가 음수일 경우 a보다 1작은 수로 설정
            // 양수일경우 그냥 그대로 둠
            if (a < 0) a = (-2) * a - 1;
            else a = 2 * a;
            if (b < 0) b = (-2) * b - 1;
            else b = 2 * b;
            // a가 거짓일 경우 b 는 반드시 참이여야 함

            graphs[oppo(a)].list.add(b);
            graphs[oppo(b)].list.add(a);
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) dfs(i);
        }

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (d[2 * i] == d[2 * i - 1]) {
                flag = true;
                break;
            }
        }
        if (flag) System.out.println(0);
        else System.out.println(1);
    }

    static int dfs(int input) {
        visited[input] = true;
        int parent = ++idx;
        stack.push(input);
        d[input] = idx;

        for (int i : graphs[input].list) {
            if (!visited[i]) parent = Math.min(parent, dfs(i));
            else if (!finished[i]) parent = Math.min(parent, d[i]);
        }

        if (parent == d[input]) {
            while (true) {
                int current = stack.pop();
                finished[current] = true;
                d[current] = parent;
                if (current == input) break;
            }
        }
        return parent;
    }

    static int oppo(int n) {
        if (n % 2 == 0) n = n - 1;
        else n = n + 1;
        return n;
    }
}
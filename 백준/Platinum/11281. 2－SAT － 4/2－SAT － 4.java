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
    static boolean[] result;
    static List<List<Integer>> SCC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        SCC = new ArrayList<>();
        graphs = new Graph[2 * N + 1];
        d = new int[2 * N + 1];
        result = new boolean[2 * N + 1];
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

            if (a < 0) a = (-2) * a - 1;
            else a = 2 * a;
            if (b < 0) b = (-2) * b - 1;
            else b = 2 * b;

            graphs[oppo(a)].list.add(b);
            graphs[oppo(b)].list.add(a);
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) dfs(i);
        }

        boolean possible = true;
        for (int i = 1; i <= N; i++) {
            if (d[2 * i] == d[2 * i - 1]) {
                possible = false;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[N + 1];
        int[] result = new int[N + 1];
        if (possible) {
            sb.append("1").append("\n");

            for (int i = SCC.size() - 1; i >= 0; i--) {

                List<Integer> scc = SCC.get(i);

                for (int j = scc.size() - 1; j >= 0; j--) {

                    int current = (scc.get(j) + 1) / 2;

                    if (!visited[current]) {
                        visited[current] = true;
                        if (scc.get(j) % 2 == 0) result[current] = 0;
                        else result[current] = 1;
                    }

                }
            }

            for (int i = 1; i <= N; i++) {
                sb.append(result[i]).append(" ");
            }
        } else {
            sb.append(0);
        }
        System.out.println(sb);
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
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int current = stack.pop();
                scc.add(current);
                finished[current] = true;
                d[current] = parent;
                if (current == input) break;
            }
            SCC.add(scc);
        }
        return parent;
    }

    static int oppo(int n) {
        if (n % 2 == 0) n = n - 1;
        else n = n + 1;
        return n;
    }
}
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
    static boolean[] visited;
    static boolean[] finished;
    static Stack<Integer> stack;
    static List<List<Integer>> SCC;
    static int[] d;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        SCC = new ArrayList<>();
        idx = 0;
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graphs = new Graph[V + 1];
        visited = new boolean[V + 1];
        finished = new boolean[V + 1];
        stack = new Stack<>();
        d = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graphs[i] = new Graph();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graphs[A].list.add(B);
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) dfs(i);
        }
        int result = 0;
        for (int i = 0; i < SCC.size(); i++) {
            result = Math.max(result, SCC.get(i).size());
        }
        System.out.println(result);
    }

    static int dfs(int input) {
        visited[input] = true;
        stack.add(input);
        int parent = ++idx;
        d[input] = parent;

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
}
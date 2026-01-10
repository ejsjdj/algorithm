import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class City {
    List<Integer> list;

    public City() {
        list = new ArrayList<>();
    }
}

public class Main {

    static int V;
    static int E;

    static int idx;
    static int[] d;
    static Stack<Integer> stack;
    static boolean[] visited;
    static boolean[] finished;
    static City[] cities;

    static List<List<Integer>> SCC;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        stack = new Stack<>();
        d = new int[V + 1];
        visited = new boolean[V + 1];
        finished = new boolean[V + 1];

        SCC = new ArrayList<>();

        cities = new City[V + 1];
        for (int i = 1; i <= V; i++) {
            cities[i] = new City();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            cities[A].list.add(B);
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) dfs(i);
        }

        if (SCC.size() == 1) System.out.println("Yes");
        else System.out.println("No");

    }

    static int dfs(int input) {
        int parent = ++idx;
        d[input] = parent;
        visited[input] = true;
        stack.push(input);

        for (int i : cities[input].list) {
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
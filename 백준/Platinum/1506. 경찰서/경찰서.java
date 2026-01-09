import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int idx;
    static int V;
    static Stack<Integer> stack;
    static int[] d;
    static List<List<Integer>> SCC;

    static boolean[] visited;
    static boolean[] finished;

    static int[][] routes;
    static int[] prices;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        idx = 0;
        SCC = new ArrayList<>();
        stack = new Stack<>();
        V = Integer.parseInt(st.nextToken());

        prices = new int[V];
        visited = new boolean[V];
        finished = new boolean[V];
        routes = new int[V][V];
        d = new int[V];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < V; i++) {
            String str = br.readLine();
            for (int j = 0; j < V; j++) {
                routes[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i);
        }

        int result = 0;

        for (int i = 0; i < SCC.size(); i++) {
            int minPrice = Integer.MAX_VALUE;
            for (int j : SCC.get(i)) {
                minPrice = Math.min(minPrice, prices[j]);
            }
            result += minPrice;
        }

        System.out.println(result);
    }

    static int dfs(int input) {
        int parent = ++idx;
        d[input] = parent;
        stack.push(input);
        visited[input] = true;

        for (int j = 0; j < V; j++) {
            if (input != j && routes[input][j] != 0) {
                if (!visited[j]) { parent = Math.min(parent, dfs(j));
                }
                else if (!finished[j]) {
                    parent = Math.min(parent, d[j]);
                }
            }
        }


        if (parent == d[input]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int current = stack.pop();
                scc.add(current);
                d[current] = parent;
                finished[current] = true;
                if (current == input) break;
            }
            SCC.add(scc);
        }

        return parent;
    }
}
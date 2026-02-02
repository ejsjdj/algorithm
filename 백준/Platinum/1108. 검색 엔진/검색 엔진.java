import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {
    List<Integer> adj;
    List<String> conn;

    public Graph() {
        adj = new ArrayList<>();
        conn = new ArrayList<>();
    }
}

public class Main {

    static int idx = 0;

    static int[] d;
    static Stack<Integer> stack;
    static boolean[] visited;
    static boolean[] finished;
    static Graph[] graphs;
    static long[] memo;
    static List<List<Integer>> SCC;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int graphIdx = 0;
        SCC = new ArrayList<>();
        stack = new Stack<>();
        d = new int[2500];
        visited = new boolean[2500];
        finished = new boolean[2500];
        graphs = new Graph[2500];
        memo = new long[2500];

        HashMap<String, Integer> stringToInteger = new HashMap<>();
        HashMap<Integer, String> integerToString = new HashMap<>();

        for (int i = 0; i < 2500; i++) graphs[i] = new Graph();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            stringToInteger.put(s, i);
            integerToString.put(i, s);
            graphIdx++;
            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                graphs[i].conn.add(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Graph now = graphs[i];
            for (int j = 0; j < now.conn.size(); j++) {
                int next = -1;
                if (stringToInteger.containsKey(now.conn.get(j))) next = stringToInteger.get(now.conn.get(j));
                else {
                    next = stringToInteger.getOrDefault(now.conn.get(j), graphIdx++);
                    stringToInteger.put(now.conn.get(j), next);
                }
                // next 는 i 를 가는 링크가 있다.
                graphs[i].adj.add(next);
            }
        }

        // 타잔알고리즘
        for (int i = 0; i < graphIdx; i++) {
            if (!visited[i]) dfs(i);
        }

        String str = br.readLine();
        if (stringToInteger.getOrDefault(str, -1) != -1) System.out.println(findPoint(stringToInteger.get(str)));
        else System.out.println(1);
    }

    static long findPoint(int input) {
        if (memo[input] != 0) return memo[input];
        long point = 1;
        for (int i : graphs[input].adj) {
            if (d[input] != d[i]) {
                point += findPoint(i);
            }
        }
        return memo[input] = point;
    }


    static int dfs(int input) {
        int parent = ++idx;
        d[input] = parent;
        stack.push(input);
        visited[input] = true;

        for (int i : graphs[input].adj) {
            if (!visited[i]) parent = Math.min(parent, dfs(i));
            else if (!finished[i]) parent = Math.min(parent, d[i]);
        }

        if (parent == d[input]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int current = stack.pop();
                d[current] = parent;
                scc.add(current);
                finished[current] = true;

                if (current == input) break;
            }
            SCC.add(scc);
        }

        return parent;
    }

}

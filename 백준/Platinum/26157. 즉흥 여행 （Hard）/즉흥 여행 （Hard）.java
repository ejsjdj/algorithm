import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {
    List<Integer> conn;

    public Graph() {
        this.conn = new ArrayList<>();
    }
}

class SCCGraph {
    Set<Integer> conn;
    public SCCGraph() {
        conn = new HashSet<>();
    }
}

public class Main {

    static Stack<Integer> stack;
    static int idx;

    static Graph[] graphs;
    static SCCGraph[] sccGraphs;

    static List<List<Integer>> SCC;
    static int[] d;
    static boolean[] visited;
    static boolean[] finished;

    static HashMap<Integer, Integer> hm;

    static int[] indegree;
    static int[] outdegree;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        idx = 0;

        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        d = new int[N + 1];
        graphs = new Graph[N + 1];

        for (int i = 0; i <= N; i++) {
            graphs[i] = new Graph();
        }

        stack = new Stack<>();
        SCC = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graphs[a].conn.add(b);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) dfs(i);
        }

        int result = findRoad();
        StringBuilder sb = new StringBuilder();
        if (result == -1) sb.append(0);
        else {
            List<Integer> scc = SCC.get(result);
            sb.append(scc.size()).append("\n");
            Collections.sort(scc);
            for (int i : scc) {
                sb.append(i + " ");
            }

        }
        System.out.println(sb);
    }

    static int findRoad() {

        sccGraphs = new SCCGraph[SCC.size()];

        for (int i = 0; i < sccGraphs.length; i++) {
            sccGraphs[i] = new SCCGraph();
        }

        indegree = new int[SCC.size()];
        outdegree = new int[SCC.size()];

        hm = new HashMap<>();

        for (int i = 0; i < SCC.size(); i++) {
            hm.put(d[SCC.get(i).get(0)] , i);
        }

        for (int i = 0; i < SCC.size(); i++) {
            List<Integer> scc = SCC.get(i);

            for (int j : scc) {

                Graph graph = graphs[j];

                for (int k : graph.conn) {
                    if (d[k] != d[j]) {
                        int a = hm.get(d[j]);
                        int b = hm.get(d[k]);
                        if (sccGraphs[a].conn.add(b)) {
                            outdegree[a]++;
                            indegree[b]++;
                        }
                    }
                }

            }
        }

        int start = -1;
        boolean flag = false;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                start = i;
                if (flag) return -1;
                flag = true;
            }
        }
        if (!flag || start == -1) return -1;

        int zeroIn = 0;
        int zeroOut = 0;

        for (int i = 0; i < SCC.size(); i++) {
            int in = indegree[i];
            int out = outdegree[i];

            if (in == 0) zeroIn++;
            if (out == 0) zeroOut++;
        }

        if (zeroIn != 1 || zeroOut != 1) return -1;

        return start;
    }


    static int dfs(int input) {
        int parent = ++idx;
        visited[input] = true;
        d[input] = parent;
        stack.push(input);

        for (int i : graphs[input].conn) {
            if (!visited[i]) parent = Math.min(parent, dfs(i));
            else if (!finished[i]) parent = Math.min(parent, d[i]);
        }

        if (parent == d[input]) {
            List<Integer> scc = new ArrayList<>();

            while (true) {
                int current = stack.pop();
                finished[current] = true;
                d[current] = parent;
                scc.add(current);

                if (current == input) break;
            }

            SCC.add(scc);

        }

        return parent;

    }



}

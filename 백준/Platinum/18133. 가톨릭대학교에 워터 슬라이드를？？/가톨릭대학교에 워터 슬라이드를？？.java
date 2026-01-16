import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Graph {
    List<Integer> list;

    public Graph() {
        this.list = new ArrayList<>();
    }
}

public class Main {

    static int[] d;
    static Stack<Integer> stack;
    static Graph[] graphs;
    static int idx = 0;
    static boolean[] visited;
    static boolean[] finished;

    static List<List<Integer>> SCC;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        d = new int[N + 1];
        stack = new Stack<>();
        graphs = new Graph[N + 1];

        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        SCC = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graphs[i] = new Graph();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graphs[a].list.add(b);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) dfs(i);
        }

        Map<Integer,Integer> hm = new HashMap<>();

        for (int i = 0; i < SCC.size(); i++) {
            int first =  SCC.get(i).get(0);
            hm.put(d[first], i);
        }

        int[] indegree = new int[SCC.size()];
        for (int i = 0; i < SCC.size(); i++) {

            List<Integer> scc = SCC.get(i);

            for (int j = 0; j < scc.size(); j++) {

                int current = scc.get(j);

                for (int k : graphs[current].list) {
                    if (d[current] != d[k]) {
                        int sccNum = hm.get(d[k]);
                        indegree[sccNum]++;
                    }
                }

            }

        }
        int cnt = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) cnt++;
        }
        System.out.println(cnt);
    }

    static int dfs(int input) {
        visited[input] = true;
        stack.push(input);
        int parent = ++idx;
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
}
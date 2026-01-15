import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {
    List<Integer> list;
    Graph () {
        list = new ArrayList<>();
    }
}

public class Main {

    static Graph[] graphs;
    static int[] d;
    static boolean[] visited;
    static boolean[] finished;
    static List<List<Integer>> SCC;
    static Stack<Integer> stack;
    static int idx;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graphs = new Graph[N];

            for (int i = 0; i < N; i++) {
                graphs[i] = new Graph();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graphs[a].list.add(b);
            }

            visited = new boolean[N];
            finished = new boolean[N];
            d = new int[N];
            idx = 0;
            SCC = new ArrayList<>();
            stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            Map<Integer, Integer> hm  = new HashMap<>();
            for (int i = 0; i < SCC.size(); i++) {
                int parent = d[SCC.get(i).get(0)];
                hm.put(parent, i);
            }
            int[] indegree = new int[SCC.size()];

            for (int i = 0; i < SCC.size(); i++) {
                List<Integer> scc = SCC.get(i);
                for (int j = 0; j < scc.size(); j++) {
                    int current = scc.get(j);
                    for (int k  : graphs[current].list) {
                        if (d[current] != d[k]) {
                            int conn = hm.get(d[k]);
                            indegree[conn]++;
                        }
                    }
                }
            }
            int unique = -1;
            boolean flag = true;
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    if (unique != -1) flag = false;
                    unique = i;
                }
            }
            if (flag) {
                StringBuilder sb = new StringBuilder();
                Collections.sort(SCC.get(unique));
                for (int i : SCC.get(unique)) {
                    sb.append(i).append("\n");
                }
                System.out.print(sb);
            } else {
                System.out.println("Confused");
            }
            System.out.println();
            if (T != 0)  br.readLine();
        }

    }

    static int dfs(int input) {
        int parent = idx++;
        d[input] = parent;
        visited[input] = true;
        stack.push(input);

        for (int i : graphs[input].list) {
            if (!visited[i]) parent = Math.min(dfs(i), parent);
            else if (!finished[i]) parent = Math.min(d[i], parent);
        }

        if (parent == d[input]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int current = stack.pop();
                d[current] = parent;
                finished[current] = true;
                scc.add(current);
                if (current == input) break;
            }
            SCC.add(scc);
        }

        return parent;
    }
}
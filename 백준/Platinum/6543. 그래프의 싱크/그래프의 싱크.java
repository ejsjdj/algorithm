import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] adj;

    // 타잔알고리즘
    static boolean[] visited;
    static boolean[] onStack;
    static int[] d;
    static int timer;
    static Stack<Integer> stack;

    // SCC 결과
    static List<List<Integer>> SCC;
    static int[] sccId;
    static int sccCnt;

    // DAG
    static int[] outDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            M = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            SCC = new ArrayList<>();
            visited = new boolean[N + 1];
            onStack = new boolean[N + 1];
            d = new int[N + 1];
            timer = 0;
            stack = new Stack<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }

            }

            sccCnt = 0;
            sccId = new int[N + 1];
            outDegree = new int[SCC.size() + 1];

            for (List<Integer> scc : SCC) {
                sccCnt++;
                for (int i : scc) {
                    sccId[i] = sccCnt;
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j : adj[i]) {
                    if (sccId[i] != sccId[j]) {
                        outDegree[sccId[i]]++;
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= SCC.size(); i++) {
                if (outDegree[i] == 0) {
                    for (int j : SCC.get(i - 1)) {
                        result.add(j);
                    }
                }
            }

            Collections.sort(result);
            StringBuilder sb = new StringBuilder();
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            System.out.print(sb);

        }
    }


    static int dfs(int curr) {
        visited[curr] = true;
        d[curr] = ++timer;
        stack.push(curr);
        onStack[curr] = true;

        int parent = d[curr];
        for (int conn : adj[curr]) {
            if (!visited[conn]) {
                parent = Math.min(parent, dfs(conn));
            } else if (onStack[conn]) {
                parent = Math.min(parent, d[conn]);
            }
        }

        if (parent == d[curr]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int peek = stack.pop();
                scc.add(peek);
                onStack[peek] = false;
                if (peek == curr) break;
            }
            SCC.add(scc);
        }
        return parent;
    }

}
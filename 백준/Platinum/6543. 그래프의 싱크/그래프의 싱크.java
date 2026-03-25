import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] adj;

    // Tarjan
    static boolean[] visited;
    static boolean[] onStack;
    static int[] disc;
    static int time;
    static Stack<Integer> stack;

    // SCC 결과
    static List<List<Integer>> sccList;
    static int[] sccId;
    static int sccCnt;

    // SCC DAG
    static int[] outDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) return;
            StringTokenizer st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            m = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            // 간선 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
            }

            // Tarjan 초기화
            visited = new boolean[n + 1];
            onStack = new boolean[n + 1];
            disc = new int[n + 1];
            time = 0;
            stack = new Stack<>();

            sccList = new ArrayList<>();

            // SCC 탐색
            for (int v = 1; v <= n; v++) {
                if (!visited[v]) {
                    dfs(v);
                }
            }

            sccCnt = 0;
            sccId = new int[n + 1];
            for (List<Integer> comp : sccList) {
                sccCnt++;
                for (int v : comp) {
                    sccId[v] = sccCnt;
                }
            }

            outDegree = new int[sccCnt + 1];
            for (int v = 1; v <= n; v++) {
                for (int nxt : adj[v]) {
                    if (sccId[v] != sccId[nxt]) {
                        outDegree[sccId[v]]++;
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int comp = 1; comp <= sccCnt; comp++) {
                if (outDegree[comp] == 0) {
                    for (int v : sccList.get(comp - 1)) {
                        result.add(v);
                    }
                }
            }

            Collections.sort(result);
            StringBuilder sb = new StringBuilder();
            for (int v : result) {
                sb.append(v).append(' ');
            }
            sb.append('\n');
            System.out.print(sb);
        }
    }

    static int dfs(int v) {
        visited[v] = true;
        disc[v] = ++time;
        stack.push(v);
        onStack[v] = true;

        int low = disc[v];

        for (int nxt : adj[v]) {
            if (!visited[nxt]) {
                low = Math.min(low, dfs(nxt));
            } else if (onStack[nxt]) {
                low = Math.min(low, disc[nxt]);
            }
        }

        if (low == disc[v]) {
            List<Integer> comp = new ArrayList<>();
            while (true) {
                int top = stack.pop();
                comp.add(top);
                onStack[top] = false;
                if (top == v) break;
            }
            sccList.add(comp);
        }

        return low;
    }
}

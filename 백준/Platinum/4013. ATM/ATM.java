import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {
    List<Integer> conn = new ArrayList<>();
    public Graph(List<Integer> conn) {
        this.conn = conn;
    }
}

public class Main {

    static int V;
    static int E;

    static boolean[] visited;
    static boolean[] finished;
    static List<List<Integer>> SCC;
    static Stack<Integer> stack;
    static Graph[] graphs;
    static int[] d;
    static int id = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] ATM;
    static int[] sccId;
    static int[] sccSum;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graphs = new Graph[V + 1];
        visited = new boolean[V + 1];
        finished = new boolean[V + 1];
        stack = new Stack<>();
        d = new int[V + 1];
        SCC = new ArrayList<>();

        ATM = new int[V + 1];

        for (int i = 1; i <= V; i++)
            graphs[i] = new Graph(new ArrayList<>());

        // 1. 간선 입력 + 그래프 구성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graphs[a].conn.add(b);
        }

        // 2. SCC 구성
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) dfs(i);
        }

        // 3. 각 정점의 ATM 값
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            ATM[i] = Integer.parseInt(st.nextToken());
        }

        // 4. 시작점 S, 레스토랑 수 P
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] restaurant = new int[V + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            int r = Integer.parseInt(st.nextToken());
            restaurant[r] = 1;
        }

        // 5. 각 정점이 속한 SCC 번호
        sccId = new int[V + 1];
        for (int i = 0; i < SCC.size(); i++) {
            for (int j : SCC.get(i)) {
                sccId[j] = i;
            }
        }

        int sccCnt = SCC.size();

        // 6. 각 SCC의 ATM 합
        sccSum = new int[sccCnt];
        for (int i = 0; i < sccCnt; i++) {
            for (int j : SCC.get(i)) {
                sccSum[i] += ATM[j];
            }
        }

        // 7. SCC-DAG 구성
        List<Integer>[] DAG = new ArrayList[sccCnt];
        for (int i = 0; i < sccCnt; i++) {
            DAG[i] = new ArrayList<>();
        }

        int[] indegree = new int[sccCnt];

        for (int i = 1; i <= V; i++) {
            List<Integer> conn = graphs[i].conn;
            for (int j : conn) {
                if (sccId[i] != sccId[j]) {
                    indegree[sccId[j]]++;
                    DAG[sccId[i]].add(sccId[j]);
                }
            }
        }

        // 8. 레스토랑이 있는지 여부를 SCC 기준으로 표시
        boolean[] sccRestaurant = new boolean[sccCnt];
        for (int i = 1; i <= V; i++) {
            if (restaurant[i] == 1) {
                sccRestaurant[sccId[i]] = true;
            }
        }

        int startScc = sccId[S];

        // 9. SCC-DAG 위상 정렬 + DP
        int[] dp = new int[sccCnt];
        Arrays.fill(dp, -1);

        Queue<Integer> q = new ArrayDeque<>();

        // 진입차수 0인 SCC들을 큐에 넣되, 시작 SCC에서만 DP 시작
        for (int i = 0; i < sccCnt; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        dp[startScc] = sccSum[startScc];

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 시작 SCC에서 도달 가능한 곳만 의미 있음
            if (dp[cur] != -1) {
                for (int next : DAG[cur]) {
                    if (dp[next] < dp[cur] + sccSum[next]) {
                        dp[next] = dp[cur] + sccSum[next];
                    }
                }
            }

            for (int next : DAG[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // 10. 레스토랑 SCC 중 최대값
        int answer = 0;
        for (int i = 0; i < sccCnt; i++) {
            if (sccRestaurant[i] && dp[i] > answer) {
                answer = dp[i];
            }
        }

        System.out.println(answer);
    }

    static int dfs(int input) {
        visited[input] = true;
        d[input] = ++id;
        stack.push(input);

        List<Integer> conn = graphs[input].conn;

        int parent = d[input];
        for (int i : conn) {
            if (!visited[i]) parent = Math.min(parent, dfs(i));
            else if (!finished[i]) parent = Math.min(parent, d[i]);
        }

        if (parent == d[input]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int top = stack.pop();
                scc.add(top);
                finished[top] = true;
                if (top == input) break;
            }
            Collections.sort(scc);
            SCC.add(scc);
        }
        return parent;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class City {
    List<Integer> forward;

    public City() {
        forward = new ArrayList<>();
    }
}

public class Main {

    static int N;
    static City[] cities;

    // 타잔 알고리즘 필요 필드
    static int idx;
    static Stack<Integer> stack;
    static boolean[] visited;
    static boolean[] finished;
    static int[] d;
    static List<List<Integer>> SCC;

    // SCC 그래프 필드
    static List<Integer>[] sccGraph;      // SCC i -> SCC j로 갈 수 있는가
    static List<Integer>[] sccGraphReverse; // SCC j -> SCC i로 갈 수 있는가 (역방향)
    static HashMap<Integer, Integer> nodeToScc; // 노드 번호 -> SCC 인덱스 매핑

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        idx = 0;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        stack = new Stack<>();
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        d = new int[N + 1];
        SCC = new ArrayList<>();

        cities = new City[N + 1];
        for (int i = 1; i <= N; i++) {
            cities[i] = new City();
        }

        // 원본 그래프 구성 (방향성)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            cities[A].forward.add(B);
        }

        // 타잔 알고리즘으로 SCC 찾기
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // SCC 그래프 초기화
        sccGraph = new ArrayList[SCC.size()];
        sccGraphReverse = new ArrayList[SCC.size()];
        nodeToScc = new HashMap<>();

        for (int i = 0; i < SCC.size(); i++) {
            sccGraph[i] = new ArrayList<>();
            sccGraphReverse[i] = new ArrayList<>();
        }

        // 노드 -> SCC 인덱스 매핑
        for (int i = 0; i < SCC.size(); i++) {
            for (int node : SCC.get(i)) {
                nodeToScc.put(node, i);
            }
        }

        // SCC 그래프 구성
        Set<String> edges = new HashSet<>(); // 중복 간선 제거
        for (int i = 1; i <= N; i++) {
            for (int j : cities[i].forward) {
                int sccI = nodeToScc.get(i);
                int sccJ = nodeToScc.get(j);

                // 같은 SCC 내의 간선은 무시
                if (sccI != sccJ) {
                    String edge = sccI + "-" + sccJ;
                    if (!edges.contains(edge)) {
                        edges.add(edge);
                        sccGraph[sccI].add(sccJ);
                        sccGraphReverse[sccJ].add(sccI);
                    }
                }
            }
        }

        // S가 속한 SCC와 T가 속한 SCC 찾기
        int sccS = nodeToScc.get(S);
        int sccT = nodeToScc.get(T);

        // S에서 도달 가능한 모든 SCC 찾기 (정방향 그래프에서 BFS)
        Set<Integer> reachableFromS = new HashSet<>();
        bfs(sccS, sccGraph, reachableFromS);

        // T에 도달 가능한 모든 SCC 찾기 (역방향 그래프에서 BFS)
        Set<Integer> reachableToT = new HashSet<>();
        bfs(sccT, sccGraphReverse, reachableToT);

        // 교집합 구하기
        Set<Integer> intersection = new HashSet<>(reachableFromS);
        intersection.retainAll(reachableToT);

        int result = tologicalSort(sccS, sccT, intersection);

        System.out.println(result);
    }

    static int tologicalSort(int sccS, int sccT, Set<Integer> intersection) {

        int[] inDegree = new int[SCC.size()];
        for (int i : intersection) {
            for (int next : sccGraph[i]) {
                if (intersection.contains(next)) {
                    inDegree[next]++;
                }
            }
        }

        int[] dp = new int[SCC.size()];
        Queue<Integer> queue = new LinkedList<>();

        // 시작 SCC 초기화
        queue.add(sccS);
        dp[sccS] = SCC.get(sccS).size();

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : sccGraph[curr]) {
                if (!intersection.contains(next)) continue;

                // DP 업데이트: 최대 방문 가능 도시 수
                dp[next] = Math.max(dp[next], dp[curr] + SCC.get(next).size());

                // 진입차수 감소
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return dp[sccT];
    }

    // 그래프에서 특정 노드에서 도달 가능한 모든 노드 찾기
    static void bfs(int start, List<Integer>[] graph, Set<Integer> result) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        queue.offer(start);
        visited[start] = true;
        result.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    result.add(next);
                    queue.offer(next);
                }
            }
        }
    }

    static int dfs(int input) {
        visited[input] = true;
        stack.push(input);
        int parent = ++idx;
        d[input] = idx;

        for (int i : cities[input].forward) {
            if (!visited[i]) {
                parent = Math.min(parent, dfs(i));
            } else if (!finished[i]) {
                parent = Math.min(parent, d[i]);
            }
        }

        if (parent == d[input]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int top = stack.pop();
                scc.add(top);
                finished[top] = true;
                if (top == input) break;
            }
            SCC.add(scc);
        }

        return parent;
    }
}
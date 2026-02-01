import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Graph, Tree 클래스는 그대로 두셔도 됩니다.
class Graph {
    List<Integer> won;
    List<Integer> lose;
    public Graph() {
        won = new ArrayList<>();
        lose = new ArrayList<>();
    }
}

class Tree {
    Set<Integer> out;
    public Tree() {
        out = new HashSet<>();
    }
}

public class Main {
    // 기존 static 변수들은 그대로 유지
    static Graph[] graphs;
    static int idx;
    static int[] d;
    static Stack<Integer> stack;
    static boolean[] visited;
    static boolean[] finished;
    static List<List<Integer>> SCC;
    static int[] sccId;
    static int[] inDegree;
    static int[] outDegree; // outDegree는 사실상 안쓰입니다.
    static Tree[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 초기화 코드 그대로 유지...
        graphs = new Graph[N + 1];
        stack = new Stack<>();
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        SCC = new ArrayList<>();
        d = new int[N + 1];
        sccId = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new Graph();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                int won = Integer.parseInt(st.nextToken());
                graphs[i].won.add(won);
                graphs[won].lose.add(i);
            }
        }
        br.close();

        // SCC 및 트리 구성 코드 그대로 유지...
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) dfs(i);
        }

        int sccCnt = SCC.size();
        for (int i = 0; i < sccCnt; i++) {
            for (int v : SCC.get(i)) sccId[v] = i;
        }

        tree = new Tree[sccCnt];
        for (int i = 0; i < sccCnt; i++) tree[i] = new Tree();
        inDegree = new int[sccCnt];

        makeDegree(N, sccCnt); // 이 함수는 그대로

        // --- 여기서부터 로직 수정 ---

        Set<Integer> S = new HashSet<>(); // 우승 가능 노드 집합
        Queue<Integer> q = new LinkedList<>(); // 위상 정렬용 큐

        // 탈락자 대기 명단 (부활을 위해 저장)
        // SCC의 인덱스를 저장합니다.
        List<Integer> back = new ArrayList<>();

        for (int i = 0; i < sccCnt; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int nowSccIdx = q.poll();
            boolean survive = false;

            // 1. 생존 여부 판단
            if (S.isEmpty()) {
                // 첫 번째 그룹은 무조건 생존 (비교 대상이 없음)
                survive = true;
            } else {
                // 현재 SCC(nowSccIdx)에 속한 노드 중 하나라도 살 수 있는지 확인
                // 조건: 현재 S에 있는 "모든" 노드가 나를 이기는가?

                // SCC 그룹 단위로 묶여있으므로, 그룹 내 어떤 노드라도 조건을 만족하면 그룹 전체 생존
                for (int node : SCC.get(nowSccIdx)) {
                    int winCount = 0;
                    for (int loser : graphs[node].lose) { // node를 이기는 사람들(loser)
                        if (S.contains(loser)) {
                            winCount++;
                        }
                    }

                    // S의 크기보다 나를 이기는 S 멤버 수가 적다
                    // == S 멤버 중 나를 못 이기는 사람이 적어도 한 명 있다.
                    if (winCount < S.size()) {
                        survive = true;
                        break;
                    }
                }
            }

            // 2. 결과 처리 및 부활 로직
            if (survive) {
                // 현재 그룹 S에 추가
                S.addAll(SCC.get(nowSccIdx));
                
                // 새로운 챔피언(now)이 등장했으므로,
                // 기존 챔피언들에게 져서 대기중이던(back) 애들도
                // 이 새로운 챔피언을 이길 가능성이 생김 -> 전부 구제하여 S에 추가
                for (int backSccIdx : back) {
                    S.addAll(SCC.get(backSccIdx));
                }
                back.clear(); // 대기 명단 초기화
            } else {
                // 지금은 자격이 없으므로 대기 명단에 추가
                back.add(nowSccIdx);
            }

            for (int nxt : tree[nowSccIdx].out) {
                inDegree[nxt]--;
                if (inDegree[nxt] == 0) q.add(nxt);
            }
        }

        List<Integer> result = new ArrayList<>(S);
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append(" ");
        for (int node : result) {
            sb.append(node).append(" ");
        }
        System.out.println(sb.toString());
    }

    static int dfs(int input) {
        visited[input] = true;
        int parent = ++idx;
        d[input] = parent;
        stack.push(input);

        for (int nxt : graphs[input].won) {
            if (!visited[nxt]) parent = Math.min(parent, dfs(nxt));
            else if (!finished[nxt]) parent = Math.min(parent, d[nxt]);
        }

        if (parent == d[input]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int current = stack.pop();
                scc.add(current);
                finished[current] = true;
                if (current == input) break;
            }
            SCC.add(scc);
        }
        return parent;
    }

    static void makeDegree(int N, int sccCnt) {
        for (int v = 1; v <= N; v++) {
            int from = sccId[v];
            for (int w : graphs[v].won) {
                int to = sccId[w];
                if (from != to) {
                    if (tree[from].out.add(to)) {
                        inDegree[to]++;
                    }
                }
            }
        }
    }
}

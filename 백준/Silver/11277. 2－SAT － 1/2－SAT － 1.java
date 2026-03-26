import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static int[] sccId;             // 각 노드가 속하는 SCC 번호
    static int[] visitOrder;        // DFS 방문 순서
    static boolean[] visited;       
    static boolean[] finished;      
    static Stack<Integer> stack;
    static int orderCount;          
    static int sccCount;            

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 변수의 개수
        int M = Integer.parseInt(st.nextToken()); // 절의 개수

        int nodeCount = 2 * N; // 각 변수마다 true, false 두 노드 존재
        graph = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        sccId = new int[nodeCount + 1];
        visitOrder = new int[nodeCount + 1];
        visited = new boolean[nodeCount + 1];
        finished = new boolean[nodeCount + 1];
        stack = new Stack<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aIdx = literalToNode(a);
            int bIdx = literalToNode(b);

            // (¬a → b), (¬b → a)
            graph.get(negate(aIdx)).add(bIdx);
            graph.get(negate(bIdx)).add(aIdx);
        }

        for (int i = 1; i <= nodeCount; i++) {
            if (!visited[i]) {
                findSCC(i);
            }
        }

        boolean isUnsatisfiable = false;
        for (int i = 1; i <= N; i++) {
            if (sccId[2 * i] == sccId[2 * i - 1]) {
                isUnsatisfiable = true;
                break;
            }
        }

        if (isUnsatisfiable) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    static int findSCC(int node) {
        visited[node] = true;
        orderCount++;
        visitOrder[node] = orderCount;
        int parent = visitOrder[node];
        stack.push(node);

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                parent = Math.min(parent, findSCC(next));
            } else if (!finished[next]) {
                parent = Math.min(parent, visitOrder[next]);
            }
        }

        if (parent == visitOrder[node]) {
            sccCount++;
            while (true) {
                int cur = stack.pop();
                finished[cur] = true;
                sccId[cur] = sccCount;
                if (cur == node) {
                    break;
                }
            }
        }

        return parent;
    }

    // 리터럴(정수 입력)을 노드 인덱스로 변환
    // 예: 1 → 2, -1 → 1
    static int literalToNode(int x) {
        int idx;
        if (x > 0) {
            idx = 2 * x;
        } else {
            idx = -2 * x - 1;
        }
        return idx;
    }

    // 해당 노드의 반대(¬변수) 인덱스를 반환
    static int negate(int idx) {
        int result;
        if (idx % 2 == 0) {
            result = idx - 1;
        } else {
            result = idx + 1;
        }
        return result;
    }
}

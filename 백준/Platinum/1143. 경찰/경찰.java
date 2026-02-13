import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {

    List<Integer> conn;
    boolean used;
    int cost;

    Graph() {
        this.conn = new ArrayList<>();
        int cost = Integer.MAX_VALUE;
        boolean used = false;
    }

}

public class Main {

    static int N, idx = 0, sccCount = 0;

    static int[] d;
    static boolean[] finished;
    static Stack<Integer> stack;

    static int[] sccId;
    static int[] sccMinIndex;
    static int[] inDegree;

    static Graph[] graphs;
    static List<List<Integer>> SCC = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graphs = new Graph[N];
        sccId = new int[N];
        sccMinIndex = new int[N];
        inDegree = new int[N];
        d = new int[N];
        finished = new boolean[N];
        stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            graphs[i] = new Graph();
            graphs[i].cost = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {

                if (str.charAt(j) == 'Y') {
                    graphs[i].conn.add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (d[i] == 0) {
                dfs(i);
            }
        }

        makeDag();
        double answer = 0;
        double cnt = 0;
        for (int i = 0; i < SCC.size(); i++) {
            if (inDegree[i] == 0) {
                answer += graphs[sccMinIndex[i]].cost;
                graphs[sccMinIndex[i]].used = true;
                cnt++;
            }
        }
        Arrays.sort(graphs, (o1, o2) -> o1.cost - o2.cost);

        for (int i = 0; i < graphs.length; i++) {
            double ave = answer / cnt;
            if (ave < graphs[i].cost) break;
            if (ave > graphs[i].cost && !graphs[i].used) {
                answer += graphs[i].cost;
                cnt++;
            }
        }

        System.out.println(answer/cnt);

    }

    static void makeDag() {
        for (int i = 0; i < N; i++) {
            for (int j : graphs[i].conn) {
                if (sccId[i] != sccId[j]) {
                    inDegree[sccId[j]]++;
                }
            }
        }
    }


    static int dfs(int input) {
        int parent = ++idx;
        d[input] = parent;
        stack.push(input);

        for (int i : graphs[input].conn) {
            if (d[i] == 0) {
                parent = Math.min(parent, dfs(i));
            } else if (!finished[i]) {
                parent = Math.min(parent, d[i]);
            }
        }

        if (parent == d[input]) {
            List<Integer> scc = new ArrayList<>();
            int min = Integer.MAX_VALUE;

            while (true) {
                int cur = stack.pop();
                scc.add(cur);
                finished[cur] = true;
                d[cur] = parent;

                // 각 scc 의 최저값의 index 를 저장
                sccId[cur] = sccCount;
                if (min > graphs[cur].cost) {
                    min = graphs[cur].cost;
                    sccMinIndex[sccCount] = cur;
                }

                if (cur == input) break;
            }

            sccCount++;
            SCC.add(scc);

        }

        return parent;
    }
}
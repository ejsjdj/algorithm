import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int a, b, weight;

    public Edge(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        List<Edge> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Edge(A, B, weight));
        }

        Collections.sort(list);

        int result = 0;
        int maxWeight = 0;
        int count = 0;

        for (Edge edge : list) {
            if (union(edge.a, edge.b)) {
                result += edge.weight;
                maxWeight = edge.weight;  // 항상 현재 간선이 가장 큰 weight임 (정렬했기 때문)
                count++;
                if (count == N - 1) break; // MST 완성
            }
        }

        // 가장 큰 간선 하나 제거
        System.out.println(result - maxWeight);
    }

    static int find(int a) {
        if (arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            arr[y] = x;
            return true;
        }
        return false;
    }
}

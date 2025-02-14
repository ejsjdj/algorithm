import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static long[] tree, lazy;
    static int startIndex;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        segment(N);
        enQuery(M, K);
    }

    static void segment(int N) throws IOException {
        startIndex = 1;
        while (startIndex < N) startIndex *= 2; // 리프 노드 시작 위치 계산
        tree = new long[startIndex * 2]; // 세그먼트 트리 배열
        lazy = new long[startIndex * 2]; // Lazy 배열
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i + startIndex - 1] = Long.parseLong(st.nextToken());
        }
        for (int i = startIndex - 1; i > 0; i--) { // 내부 노드 초기화
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    static void updateRange(int node, int start, int end, int left, int right, long value) {
        if (lazy[node] != 0) { // Lazy 값이 있으면 먼저 갱신
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) { // 리프 노드가 아니면 자식들에게 Lazy 값 전파
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0; // 현재 노드의 Lazy 값 초기화
        }

        if (start > right || end < left) return; // 범위 밖이면 종료

        if (start >= left && end <= right) { // 완전히 포함되는 경우
            tree[node] += (end - start + 1) * value;
            if (start != end) { // 리프 노드가 아니면 자식들에게 Lazy 값 저장
                lazy[node * 2] += value;
                lazy[node * 2 + 1] += value;
            }
            return;
        }

        int mid = (start + end) / 2;
        updateRange(node * 2, start, mid, left, right, value);
        updateRange(node * 2 + 1, mid + 1, end, left, right, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1]; // 자식 노드 값 합산
    }

    static long query(int node, int start, int end, int left, int right) {
        if (lazy[node] != 0) { // Lazy 값이 있으면 먼저 갱신
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) { // 리프 노드가 아니면 자식들에게 Lazy 값 전파
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0; // 현재 노드의 Lazy 값 초기화
        }

        if (start > right || end < left) return 0; // 범위 밖이면 결과 없음

        if (start >= left && end <= right) return tree[node]; // 완전히 포함되는 경우

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right)
             + query(node * 2 + 1, mid + 1, end, left, right); // 자식 노드 값 합산
    }

    static void enQuery(int M, int K) throws IOException {
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int queryType = Integer.parseInt(st.nextToken());
            if (queryType == 1) { // 구간 업데이트
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                updateRange(1, 1, startIndex, left, right, value);
            } else { // 구간 합 쿼리
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                System.out.println(query(1, 1, startIndex, left, right));
            }
        }
    }
}
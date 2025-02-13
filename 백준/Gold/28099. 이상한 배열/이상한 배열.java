import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 배열 길이
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // 세그먼트 트리 초기화
            segmentTree = new int[4 * N];
            buildSegmentTree(A, 0, N - 1, 1);

            // 숫자별 등장 위치 저장
            Map<Integer, List<Integer>> positions = new HashMap<>();
            for (int i = 0; i < N; i++) {
                positions.computeIfAbsent(A[i], k -> new ArrayList<>()).add(i);
            }

            boolean isWeirdArray = true;

            // 각 숫자에 대해 이상한 배열 조건 확인
            for (List<Integer> indices : positions.values()) {
                for (int i = 0; i < indices.size() - 1; i++) {
                    int left = indices.get(i);
                    int right = indices.get(i + 1);

                    if (right - left > 1) { // 구간에 값이 존재할 때만 확인
                        int maxInRange = query(0, N - 1, 1, left + 1, right - 1);
                        if (maxInRange > A[left]) { // 이상한 배열 조건 위반
                            isWeirdArray = false;
                            break;
                        }
                    }
                }
                if (!isWeirdArray) break;
            }

            sb.append(isWeirdArray ? "Yes" : "No").append("\n");
        }

        System.out.println(sb.toString());
    }

    // 세그먼트 트리 빌드
    static void buildSegmentTree(int[] arr, int start, int end, int node) {
        if (start == end) {
            segmentTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildSegmentTree(arr, start, mid, node * 2);
        buildSegmentTree(arr, mid + 1, end, node * 2 + 1);

        segmentTree[node] = Math.max(segmentTree[node * 2], segmentTree[node * 2 + 1]);
    }

    // 세그먼트 트리 쿼리: 특정 구간 [left, right]에서 최대값 찾기
    static int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) { // 범위 밖
            return Integer.MIN_VALUE;
        }

        if (left <= start && end <= right) { // 범위 안
            return segmentTree[node];
        }

        int mid = (start + end) / 2;
        return Math.max(query(start, mid, node * 2, left, right),
                        query(mid + 1, end, node * 2 + 1, left, right));
    }
}
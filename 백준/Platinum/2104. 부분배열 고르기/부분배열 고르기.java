import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static long[] sumTree;   // 구간 합 세그트리
    static int[] minIdxTree; // 구간 최솟값 인덱스 세그트리
    static int[] a;          // 입력 배열 (1-based)

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        sumTree = new long[N * 4];
        minIdxTree = new int[N * 4];
        a = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        buildSum(1, 1, N);
        buildMinIdx(1, 1, N);

        System.out.println(solve(1, N));
    }

    // 합 세그트리 build
    static long buildSum(int node, int start, int end) {
        if (start == end) {
            return sumTree[node] = a[start];
        }
        int mid = (start + end) / 2;
        long left = buildSum(node * 2, start, mid);
        long right = buildSum(node * 2 + 1, mid + 1, end);
        return sumTree[node] = left + right;
    }

    // 최소 인덱스 세그트리 build
    static int buildMinIdx(int node, int start, int end) {
        if (start == end) {
            return minIdxTree[node] = start;
        }
        int mid = (start + end) / 2;
        int leftIdx = buildMinIdx(node * 2, start, mid);
        int rightIdx = buildMinIdx(node * 2 + 1, mid + 1, end);
        return minIdxTree[node] =
                (a[leftIdx] <= a[rightIdx]) ? leftIdx : rightIdx;
    }

    // [l, r] 구간 합
    static long getSum(int l, int r, int node, int start, int end) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return sumTree[node];
        }
        int mid = (start + end) / 2;
        return getSum(l, r, node * 2, start, mid)
             + getSum(l, r, node * 2 + 1, mid + 1, end);
    }

    // [l, r] 구간에서의 최솟값 인덱스
    static int getMinIdx(int l, int r, int node, int start, int end) {
        if (r < start || end < l) {
            return 0; // sentinel
        }
        if (l <= start && end <= r) {
            return minIdxTree[node];
        }
        int mid = (start + end) / 2;
        int leftIdx = getMinIdx(l, r, node * 2, start, mid);
        int rightIdx = getMinIdx(l, r, node * 2 + 1, mid + 1, end);

        if (leftIdx == 0) return rightIdx;
        if (rightIdx == 0) return leftIdx;
        return (a[leftIdx] <= a[rightIdx]) ? leftIdx : rightIdx;
    }

    // [l, r] 구간에서 최대 score를 구하는 분할정복
    static long solve(int l, int r) {
        if (l > r) {
            return 0;
        }

        int mid = getMinIdx(l, r, 1, 1, N);   // 최소값 인덱스
        long sum = getSum(l, r, 1, 1, N);     // 구간 합
        long midScore = sum * a[mid];

        long leftScore = solve(l, mid - 1);
        long rightScore = solve(mid + 1, r);

        return Math.max(midScore, Math.max(leftScore, rightScore));
    }
}
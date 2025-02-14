import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static int start;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
        	try {
        		st = new StringTokenizer(br.readLine());
        		sb = new StringBuilder();
        		int width = Integer.parseInt(st.nextToken());
        		int query = Integer.parseInt(st.nextToken());
        		segmentTree(width);
        		for (int i = 0; i < query; i++) {
        			st = new StringTokenizer(br.readLine());
        			String str = st.nextToken();
        			if (str.equals("C")) change();
        			else multi();
        		}
        		System.out.println(sb);        		
        	} catch (Exception e) {
        		break;
        	}
        }
    }

    static void segmentTree(int width) throws IOException {
        tree = new int[width(width)];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < width; i++) {
            int idx = i + start;
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) tree[idx] = 0;
            else if (input > 0) tree[idx] = 1;
            else tree[idx] = -1;
        }
        for (int i = start - 1; i > 0; i--) { // 내부 노드 초기화
            tree[i] = tree[2 * i] * tree[2 * i + 1];
        }
    }

    static int width(int width) {
        start = 1;
        while (start < width) start *= 2;
        return start * 2; // 세그먼트 트리 배열 크기
    }

    static void multi() {
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        s += start - 1; // 실제 인덱스 변환
        e += start - 1;
        int result = 1;
        while (s <= e) {
            if (s % 2 == 1) result *= tree[s++];
            if (e % 2 == 0) result *= tree[e--];
            s /= 2;
            e /= 2;
        }
        if (result == 0) sb.append("0");
        else if (result > 0) sb.append("+");
        else sb.append("-");
    }

    static void change() {
        int s = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        if (v == 0) v = 0;
        else if (v > 0) v = 1;
        else v = -1;
        s += start - 1; // 실제 인덱스 변환
        tree[s] = v;
        while (s > 1) {
            s /= 2;
            tree[s] = tree[2 * s] * tree[2 * s + 1];
        }
    }
}
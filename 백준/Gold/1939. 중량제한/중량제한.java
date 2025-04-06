import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

    static int N, M;
    static ArrayList<Point> arrList[];
    static boolean visit[];
    static int begin, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());	// 섬의 개수
        M = Integer.parseInt(st.nextToken());	// 다리의 개수

        arrList = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arrList[i] = new ArrayList<>();
        }

        int low = 999999;
        int high = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            low = Math.min(low, val);
            high = Math.max(high, val);
            arrList[u].add(new Point(v, val));
            arrList[v].add(new Point(u, val));
        }
        st = new StringTokenizer(br.readLine());
        begin = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 이분탐색을 두 포인트 방식으로 수행
        while (low <= high) { 
            visit = new boolean[N + 1];
            int mid = (low + high) / 2;
            // 목적지에 도착했다면 정답을 갱신해요.
            if (bfs(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }

    private static boolean bfs(int val) {
        Queue<Integer> queue = new LinkedList<>();
        visit[begin] = true;
        queue.add(begin);

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (poll == end) {
                return true;
            }

            for (int i = 0; i < arrList[poll].size(); i++) {
                // 이미 방문한 섬과 중량 제한을 넘어가는 다리는 건너지 않아요.
                if (!visit[arrList[poll].get(i).x] && arrList[poll].get(i).y >= val) {
                    visit[arrList[poll].get(i).x] = true;
                    queue.add(arrList[poll].get(i).x);
                }
            }
        }
        return false;
    }
}
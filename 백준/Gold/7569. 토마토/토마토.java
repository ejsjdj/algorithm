import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken()); // 상자의 가로
        int N = Integer.parseInt(st.nextToken()); // 상자의 세로
        int H = Integer.parseInt(st.nextToken()); // 상자의 높이

        int[][][] box = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        // 방향 벡터 (위, 아래, 앞, 뒤, 왼쪽, 오른쪽)
        int[] dx = {0, 0, 0, 0, -1, 1};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {-1, 1, 0, 0, 0, 0};

        // 입력 처리 및 초기 상태 설정
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) { // 익은 토마토라면 큐에 추가
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[2];
            int y = now[1];
            int z = now[0];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && nx < M &&
                    ny >= 0 && ny < N &&
                    nz >= 0 && nz < H &&
                    box[nz][ny][nx] == 0) { // 익지 않은 토마토만 처리
                    box[nz][ny][nx] = box[z][y][x] + 1; // 날짜 갱신
                    queue.add(new int[]{nz, ny, nx});
                }
            }
        }

        // 결과 계산
        int maxDays = Integer.MIN_VALUE;
        boolean hasUnripeTomato = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) { // 익지 않은 토마토가 남아 있다면
                        hasUnripeTomato = true;
                    }
                    maxDays = Math.max(maxDays, box[i][j][k]);
                }
            }
        }

        if (hasUnripeTomato) {
            System.out.println(-1); // 모든 토마토를 익힐 수 없음
        } else {
            System.out.println(maxDays - 1); // 초기값이 1이므로 최종 일수는 -1
        }
    }
}
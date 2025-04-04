import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] cleaned;
    static int r, c, d;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        map = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        sc.close();
        
        int count = cleanRoom();
        System.out.println(count);
    }

    public static int cleanRoom() {
        int cleanedCount = 0;

        while (true) {
            // 1. 현재 위치를 청소한다.
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                cleanedCount++;
            }

            boolean cleanedOrWallAround = true;
            for (int i = 0; i < 4; i++) {
                int nd = (d + 3) % 4; // 현재 방향의 왼쪽 방향
                int nx = r + dx[nd];
                int ny = c + dy[nd];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && !cleaned[nx][ny]) {
                    // 청소하지 않은 공간이 있으면 그 방향으로 전진 (정상 좌표이면서 청소가되어 있지 않으며 이동가능한 좌표)
                    r = nx;
                    c = ny;
                    d = nd;
                    cleanedOrWallAround = false;
                    break;
                }

                // 방향을 왼쪽으로 회전
                d = nd;
            }

            if (cleanedOrWallAround) {
                // 네 방향 모두 청소가 이미 되어 있거나 벽인 경우
                int backDirection = (d + 2) % 4;
                int bx = r + dx[backDirection];
                int by = c + dy[backDirection];

                if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] == 0) {
                    // 후진할 수 있으면 후진
                    r = bx;
                    c = by;
                } else {
                    // 후진할 수 없으면 작동을 멈춘다.
                    break;
                }
            }
        }

        return cleanedCount;
    }
}
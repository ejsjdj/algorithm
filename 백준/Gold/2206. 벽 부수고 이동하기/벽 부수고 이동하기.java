import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] wall;
    static int[][][] dist; // dist[x][y][usedBreak]: 최소 이동 칸 수
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wall = new boolean[N][M];
        dist = new int[N][M][2];  
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                wall[i][j] = (row.charAt(j) == '1');
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        // {x, y, usedBreak}
        q.offer(new int[]{0, 0, 0});
        dist[0][0][0] = 1;  // 출발 칸 포함

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], used = cur[2];
            int step = dist[x][y][used];

            if (x == N-1 && y == M-1) {
                return step;
            }

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 다음 칸이 벽인 경우
                if (wall[nx][ny]) {
                    if (used == 0 && dist[nx][ny][1] == 0) {
                        dist[nx][ny][1] = step + 1;
                        q.offer(new int[]{nx, ny, 1});
                    }
                }
                // 다음 칸이 빈칸인 경우
                else {
                    if (dist[nx][ny][used] == 0) {
                        dist[nx][ny][used] = step + 1;
                        q.offer(new int[]{nx, ny, used});
                    }
                }
            }
        }

        return -1;  // 도달 불가
    }
}

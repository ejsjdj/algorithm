import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int w; 
    static int h; 
    static int[][] map;
    static boolean[][] visited;
    // 8방향 이동 (상하좌우 + 대각선)
    static int[][] move = new int[][] {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1},  {1, 0},  {1, 1}
    };
    static Queue<int[]> queue;

    static void makingMap() throws IOException {
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int cntIsland() {
        visited = new boolean[h][w];
        int cnt = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    cnt++;
                    
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for (int[] moveDir : move) {
                            int move_x = now[0] + moveDir[0];
                            int move_y = now[1] + moveDir[1];
                            
                            if (move_x >= 0 && move_x < h && 
                                move_y >= 0 && move_y < w && 
                                !visited[move_x][move_y] && 
                                map[move_x][move_y] == 1) {
                                
                                visited[move_x][move_y] = true;
                                queue.add(new int[] {move_x, move_y});
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if (w == 0 && h == 0) break;
            
            makingMap();
            int islandCount = cntIsland();
            System.out.println(islandCount); 
        }
    }
}
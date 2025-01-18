import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int[][] comb = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[N][N];
        int normalCount = countRegions(false);

        visited = new boolean[N][N];
        int colorBlindCount = countRegions(true);

        System.out.println(normalCount + " " + colorBlindCount);
    }

    static int countRegions(boolean isColorBlind) {
        int count = 0;
        Queue<Pos> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!visited[i][j]) {
                    queue.add(new Pos(i, j));
                    visited[i][j] = true;
                    count++;

                    while (!queue.isEmpty()) {
                        Pos pos = queue.poll();

                        for (int[] direction : comb) {
                            int nx = pos.x + direction[0];
                            int ny = pos.y + direction[1];

                            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !visited[nx][ny]) {
                                if (isColorBlind) {
                                    if ((arr[pos.x][pos.y] == 'R' || arr[pos.x][pos.y] == 'G') &&
                                        (arr[nx][ny] == 'R' || arr[nx][ny] == 'G')) {
                                        queue.add(new Pos(nx, ny));
                                        visited[nx][ny] = true;
                                    } else if (arr[pos.x][pos.y] == arr[nx][ny]) {
                                        queue.add(new Pos(nx, ny));
                                        visited[nx][ny] = true;
                                    }
                                } else {
                                    // Normal vision
                                    if (arr[pos.x][pos.y] == arr[nx][ny]) {
                                        queue.add(new Pos(nx, ny));
                                        visited[nx][ny] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
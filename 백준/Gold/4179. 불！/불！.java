import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] miro;
    static int row, col;
    static int[][] move = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> fire;
    static Queue<int[]> jihun;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        fire = new ArrayDeque<>();
        jihun = new ArrayDeque<>();

        miro = new int[row][col];
        for (int i = 0; i < row; i++) {

            String str = br.readLine();

            for (int j = 0; j < col; j++) {

                if (str.charAt(j) == '#') miro[i][j] = -2;

                else if (str.charAt(j) == 'J') {
                    miro[i][j] = 1;
                    jihun.add(new int[]{i, j});
                }
                else if (str.charAt(j) == 'F'){
                    miro[i][j] = -1;
                    fire.add(new int[]{i, j});
                } else {
                    miro[i][j] = 0;
                }
            }
        }
        int result = update();

        if (result == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(result);

    }

    static int update() {

        while (!jihun.isEmpty()) {

            int len = jihun.size();

            while (len-- > 0) {
                int[] jihunPos = jihun.poll();
                int r = jihunPos[0];
                int c = jihunPos[1];

                if (miro[r][c] > 0) {
                    if (r == 0 || r == row - 1 || c == 0 || c == col - 1) return miro[r][c];
                    for (int[] m : move) {
                        int nr = r + m[0];
                        int nc = c + m[1];
                        if (0 <= nr && nr < row && 0 <= nc && nc < col && miro[nr][nc] == 0) {
                            miro[nr][nc] = miro[r][c] + 1;
                            jihun.add(new int[]{nr,nc});
                        }
                    }
                }
            }

            len = fire.size();

            while (len-- > 0) {
                int[] firePos = fire.poll();
                int r = firePos[0];
                int c = firePos[1];

                if (miro[r][c] == -1) {
                    for (int[] m : move) {
                        int nr = r + m[0];
                        int nc = c + m[1];
                        if (0 <= nr && nr < row && 0 <= nc && nc < col && miro[nr][nc] != -1 && miro[nr][nc] != -2) {
                            miro[nr][nc] = -1;
                            fire.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        return -1;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int[] xp = {-1, 0, 0, 1};
        int[] yp = {0, 1, -1, 0};
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0'; 
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    int cnt = 1; // 시작 위치의 집도 세어야 함
                    Queue<Integer[]> queue = new LinkedList<>();
                    queue.add(new Integer[] {i, j});
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        Integer[] location = queue.poll();
                        int x = location[0];
                        int y = location[1];
                        for (int k = 0; k < 4; k++) {
                            int new_x = x + xp[k];
                            int new_y = y + yp[k];
                            if (0 <= new_x && new_x < N && 0 <= new_y && new_y < N && arr[new_x][new_y] == 1 && !visited[new_x][new_y]) {
                                cnt += 1;
                                visited[new_x][new_y] = true;
                                queue.add(new Integer[] {new_x, new_y});
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        
        Collections.sort(list); // 결과를 오름차순으로 정렬
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }
}
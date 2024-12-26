import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][5];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean[][] friendship = new boolean[N][N];
        
        // 우정 관계 설정
        for (int i = 0; i < 5; i++) { 
            for (int j = 0; j < arr.length; j++) { 
                int now = arr[j][i]; 
                for (int k = j + 1; k < arr.length; k++) { 
                    if (now == arr[k][i]) { 
                        friendship[j][k] = true; 
                        friendship[k][j] = true; 
                    }
                }
            }
        }
        
        int[] count = new int[N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (friendship[i][j]) count[i]++;
            }
        }
        
        int max = 0;
        int studentIdx = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                studentIdx = i;
            }
        }
        
        System.out.println(studentIdx + 1);
    }
}
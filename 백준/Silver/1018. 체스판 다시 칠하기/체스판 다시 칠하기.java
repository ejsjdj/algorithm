import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        boolean[][] visited = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            String str = bf.readLine();
            for (int j = 0; j < N; j++) {
                 visited[i][j] = str.charAt(j) == 'W';
            }
        }
        
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i <= M-8; i++) {
        	for (int j = 0; j <= N-8; j++) {
        		boolean indx = false;
                int cnt1 = 0;
                int cnt2 = 0;
                
        		for (int k = i; k < i + 8; k++) {
        			indx = k % 2 == 0;
        			for (int l = j; l < j + 8; l++) {
        				if (visited[k][l] == indx) cnt1++;
        				else cnt2++;
        				indx = !indx;
        			}
        		}
        		result = Math.min(result,  Math.min(cnt1,  cnt2));
        	}
        }
        
        System.out.println(result);
        
    }
}
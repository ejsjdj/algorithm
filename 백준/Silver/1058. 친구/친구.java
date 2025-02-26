import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        boolean[][] friends = new boolean[N][N];
        
        // 친구 관계 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == 'Y') friends[i][j] = true;
            }
        }
        
        int maxFriends = 0; // 최대 친구 수
        
        // 각 사람마다 2-친구를 계산
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            
            for (int j = 0; j < N; j++) {
                if (friends[i][j]) { // 직접 친구인 경우
                    set.add(j);
                    for (int k = 0; k < N; k++) {
                        if (friends[j][k] && k != i) { // 친구의 친구인 경우
                            set.add(k);
                        }
                    }
                }
            }
            
            maxFriends = Math.max(maxFriends, set.size());
        }
        
        System.out.println(maxFriends);
    }
}
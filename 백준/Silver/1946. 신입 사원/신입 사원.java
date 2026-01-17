import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int[] candidates = new int[n + 1];
            
            // 서류 순위를 인덱스로, 면접 순위를 값으로 저장
            for (int i = 0; i < n; i++) {
                candidates[sc.nextInt()] = sc.nextInt();
            }
            
            int count = 1;
            int minInterview = candidates[1];
            
            for (int k = 2; k <= n; k++) {
                if (candidates[k] < minInterview) {
                    minInterview = candidates[k];
                    count++;
                }
            }
            
            System.out.println(count);
        }
    }
}

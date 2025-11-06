import java.io.*;
import java.util.*;

public class Main {
    static int[] passScore = {0, 100, 90, 95, 90, 80};
    static int[] minScore = {0, 18, 18, 18, 0, 0}; // 4,5급 언어/독해 과락 체크 없음(0)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int grade = Integer.parseInt(st.nextToken());
            int lan = Integer.parseInt(st.nextToken());
            int read = Integer.parseInt(st.nextToken());
            int listen = Integer.parseInt(st.nextToken());

            boolean isInterest = false;
            // 1,2급만
            if(grade == 1 || grade == 2){
                if(listen >= 50){
                    int cnt1 = 0, cnt2 = 0;
                    // 청해 제외 언어/독해
                    int[] arr = {lan, read};
                    for(int j=0;j<2;j++){
                        // 3-1) 해당 영역의 점수×3 < 총점 최소 합격점
                        if(arr[j]*3 < passScore[grade]) cnt1++;
                        // 3-2) 해당 영역 점수가 과락 기준점+3을 넘지 않는다.
                        if(arr[j] <= minScore[grade]+3) cnt2++;
                    }
                    // 조건 3만족
                    if(cnt1>=2 || cnt2>=1){
                        isInterest = true;
                    }
                }
            }
            sb.append(isInterest?"YES\n":"NO\n");
        }
        System.out.print(sb);
    }
}
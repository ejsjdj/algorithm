import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 현재 시각 파싱
        String[] current = br.readLine().split(":");
        int currentSec = Integer.parseInt(current[0]) * 3600 
                       + Integer.parseInt(current[1]) * 60 
                       + Integer.parseInt(current[2]);
        
        // 강의 시작 시각 파싱
        String[] lecture = br.readLine().split(":");
        int lectureSec = Integer.parseInt(lecture[0]) * 3600 
                       + Integer.parseInt(lecture[1]) * 60 
                       + Integer.parseInt(lecture[2]);
        
        // t와 k 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 달릴 때 걸리는 시간: t * (100 - k) / 100
        int runTime = t * (100 - k) / 100;
        
        // 남은 시간 계산
        int remainTime = lectureSec - currentSec;
        
        // 달려서 도착 가능한지 판단
        if (runTime <= remainTime) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

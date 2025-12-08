import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 시
        int B = Integer.parseInt(st.nextToken()); // 분
        int C = Integer.parseInt(st.nextToken()); // 초

        int D = Integer.parseInt(br.readLine());  // 요리 시간 (초)

        int total = A * 3600 + B * 60 + C + D;

        int hour = (total / 3600) % 24;
        int minute = (total % 3600) / 60;
        int second = total % 60;

        System.out.println(hour + " " + minute + " " + second);
    }
}

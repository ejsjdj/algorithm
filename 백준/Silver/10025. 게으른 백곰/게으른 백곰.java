import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int bucketCount = Integer.parseInt(tokenizer.nextToken()); // 얼음 양동이 개수
        int range = Integer.parseInt(tokenizer.nextToken()) * 2 + 1; // 이동 가능한 범위 (2K + 1)

        int[] iceAmounts = new int[1000001]; // 각 위치의 얼음 양을 저장할 배열
        for (int i = 0; i < bucketCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int iceAmount = Integer.parseInt(tokenizer.nextToken()); // 얼음 양
            int position = Integer.parseInt(tokenizer.nextToken()); // 위치
            iceAmounts[position] = iceAmount;
        }

        int currentSum = 0; // 현재 슬라이딩 윈도우 내의 얼음 총합
        int maxIce = 0; // 최대 얼음 양

        // 슬라이딩 윈도우를 이용해 최대값 계산
        for (int i = 0; i <= 1000000; i++) {
            if (i - range >= 0) {
                currentSum -= iceAmounts[i - range]; // 윈도우 범위를 벗어난 값 제거
            }
            currentSum += iceAmounts[i]; // 현재 위치의 값을 추가
            maxIce = Math.max(maxIce, currentSum); // 최대값 갱신
        }

        System.out.println(maxIce);
    }
}
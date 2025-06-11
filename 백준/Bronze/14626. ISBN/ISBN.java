import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();

        int sum = 0;
        int missingIdx = -1;
        int weight = 1; // 1 또는 3

        int checkNum = numbers.charAt(12) - '0';

        for (int i = 0; i < 12; i++) {
            char c = numbers.charAt(i);
            if (c == '*') {
                missingIdx = i;
                weight = (i % 2 == 0) ? 1 : 3;
            } else {
                int num = c - '0';
                sum += (i % 2 == 0) ? num : num * 3;
            }
        }

        // x: 손상된 자리에 들어갈 숫자 (0~9)
        for (int x = 0; x <= 9; x++) {
            int total = sum + x * weight + checkNum;
            if (total % 10 == 0) {
                System.out.println(x);
                break;
            }
        }
    }
}
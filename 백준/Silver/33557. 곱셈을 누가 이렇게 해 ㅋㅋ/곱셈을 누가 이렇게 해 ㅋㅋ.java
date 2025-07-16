import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String num1 = st.nextToken();
            String num2 = st.nextToken();

            long correctResult = Long.parseLong(num1) * Long.parseLong(num2);

            int maxLen = Math.max(num1.length(), num2.length());

            num1 = padLeft(num1, maxLen);
            num2 = padLeft(num2, maxLen);

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < maxLen; j++) {
                int digit1 = num1.charAt(j) - '0';
                int digit2 = num2.charAt(j) - '0';
                sb.append(digit1 * digit2);
            }

            long digitMulValue = Long.parseLong(sb.toString());

            if(correctResult == digitMulValue) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        br.close();
    }

    public static String padLeft(String s, int maxLen) {
        int diff = maxLen - s.length();

        return "1".repeat(diff) + s;
    }
}
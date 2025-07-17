import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine().trim();
        String bomb = br.readLine().trim();
        int bombLen = bomb.length();

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));

            // sb의 마지막 bombLen 길이만큼이 폭발 문자열이면 제거
            if (sb.length() >= bombLen) {
                boolean isBomb = true;
                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}

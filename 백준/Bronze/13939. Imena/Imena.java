import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean isName(String word, boolean isLastWord) {
        int len = word.length();
        if (len == 0) return false;

        // 마지막 글자가 문장부호면 떼어내고 검사
        char last = word.charAt(len - 1);
        boolean hasPunc = (last == '.' || last == '?' || last == '!');
        if (hasPunc) {
            if (!isLastWord) return false; // 문장 마지막 단어가 아닌데 문장부호가 있으면 이름 아님
            if (len == 1) return false;    // 단일 문장부호는 단어가 아님
            len--;                          // len-1 까지만 글자 검사
        }

        // 첫 글자: 대문자
        char c0 = word.charAt(0);
        if (!(c0 >= 'A' && c0 <= 'Z')) return false;

        // 나머지 글자: 소문자만
        for (int i = 1; i < len; i++) {
            char c = word.charAt(i);
            if (!(c >= 'a' && c <= 'z')) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        String line = br.readLine();           // N개의 문장이 한 줄에 들어 있음

        String[] tokens = line.split(" +");    // 공백 1개 이상 기준으로 단어 분리

        int[] ans = new int[N];               // 각 문장별 이름 개수
        int sentenceIdx = 0;

        for (int i = 0; i < tokens.length; i++) {
            String w = tokens[i];

            // 이 단어가 현재 문장의 마지막 단어인지 판단
            boolean endsSentence = false;
            char last = w.charAt(w.length() - 1);
            if (last == '.' || last == '?' || last == '!') {
                endsSentence = true;
            }

            if (isName(w, endsSentence)) {
                ans[sentenceIdx]++;
            }

            // 문장 끝이면 다음 문장으로
            if (endsSentence) {
                sentenceIdx++;
                if (sentenceIdx == N) break; // 안전하게 끊어주기
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.print(sb);
    }
}
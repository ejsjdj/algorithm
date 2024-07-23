import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    private static List<String> dictionary = new ArrayList<>();

    public int solution(String word) {
        generateWords("", 0);
        Collections.sort(dictionary); // 사전 순서로 정렬

        return findWordPosition(word);
    }

    private void generateWords(String current, int length) {
        if (length > 5) { // 최대 길이는 5
            return;
        }
        if (!current.isEmpty()) {
            dictionary.add(current);
        }
        for (char vowel : VOWELS) {
            generateWords(current + vowel, length + 1);
        }
    }

    private int findWordPosition(String word) {
        return dictionary.indexOf(word) + 1; // 인덱스는 0부터 시작하므로 +1
    }
}
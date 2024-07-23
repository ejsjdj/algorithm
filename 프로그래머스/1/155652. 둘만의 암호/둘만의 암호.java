import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        
        // skip 문자열을 Set에 저장
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        
        for (char c : s.toCharArray()) {
            char now = c;
            int cnt = 0;
            // index 만큼 알파벳을 이동
            while (cnt < index) {
                now++;
                if (now > 'z') {
                    now -= 26;
                }
                // skip에 포함되지 않은 경우 cnt 증가
                if (!skipSet.contains(now)) {
                    cnt++;
                }
            }
            answer.append(now);
        }
        return answer.toString();
    }
}
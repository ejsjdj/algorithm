class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            answer[i] = move(s[i]);
        }
        
        return answer;
    }
    
    String move(String s) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder(s);
        
        // "110" 패턴 찾아서 제거
        for (int i = 0; i <= sb.length() - 3; i++) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1' && sb.charAt(i + 2) == '0') {
                cnt++;
                sb.delete(i, i + 3);
                // 이전 위치부터 다시 확인 (연속된 110 패턴 처리)
                i = Math.max(-1, i - 3);
            }
        }
        
        // 빈 문자열 처리
        if (sb.length() == 0) {
            for (int i = 0; i < cnt; i++) {
                sb.append("110");
            }
            return sb.toString();
        }
        
        // "110" 삽입 위치 찾기 - 마지막 0의 위치 또는 11이 연속으로 나오기 직전
        int insertPos = -1;
        
        // 마지막 0의 위치 찾기
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                insertPos = i + 1;
                break;
            }
        }
        
        // 0이 없으면 맨 앞에 삽입
        if (insertPos == -1) {
            insertPos = 0;
        }
        
        // "110" 삽입
        for (int i = 0; i < cnt; i++) {
            sb.insert(insertPos, "110");
            insertPos += 3;  // 다음 삽입 위치 조정
        }
        return sb.toString();
    }
}
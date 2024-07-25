class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] linea = new int[300]; // 충분한 크기의 배열
        
        for (int i = 0; i < lines.length; i++) {
            int a = lines[i][0] + 150; // 시작점
            int b = lines[i][1] + 150; // 끝점
            // 선분 범위에 따라 증가
            for (int j = a; j < b; j++) {
                linea[j]++;
            }
        }
        
        // 선분이 겹치는 부분을 세기
        for (int i = 0; i < linea.length - 1; i++) {
            if (linea[i] >= 2) {
                answer++;
            }
        }
        
        return answer;
    }
}
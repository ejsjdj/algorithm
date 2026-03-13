class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int left = Math.max(lines[0][0], lines[1][0]);
        int right = Math.min(lines[0][1], lines[1][1]);
        if (right - left > 0) answer += right - left;
        
        left = Math.max(lines[1][0], lines[2][0]);
        right = Math.min(lines[1][1], lines[2][1]);
        if (right - left > 0) answer += right - left;
        
        left = Math.max(lines[2][0], lines[0][0]);
        right = Math.min(lines[2][1], lines[0][1]);
        if (right - left > 0) answer += right - left;
        
        left = Math.max(Math.max(lines[0][0], lines[1][0]), lines[2][0]);
        right = Math.min(Math.min(lines[0][1], lines[1][1]), lines[2][1]);
        if (right - left > 0) answer -= (right - left) * 2;
        
        return answer;
    }
}
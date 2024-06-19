class Solution {
    public int solution(int n, int m, int[] section) {
        		// n 벽의 총 길이, m 은 롤러가 한번에 색칠 가능한 길이 
        					// section 은 색칠해야 하는 벽면을 나타내는 배열
        int start = section[0] + m;
        int cnt = 1;
        for (int i : section) {
        	if (start <= i) {
        		start = i + m;
        		cnt += 1;
        	}
        }
        return cnt;
    }
}
class Solution {
    
    StringBuilder sb;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            
            sb = new StringBuilder(Long.toBinaryString(numbers[i]));
            int len = 1;
            while (sb.length() > len - 1) len = 2 * len;
            len = len - 1;
            
            while (sb.length() < len) sb.insert(0, '0');
            
            if (dfs(0, len / 2, len - 1)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
    
    boolean dfs(int start, int root, int end) {
        if (start == end) return true;
        if (sb.charAt(root) == '0') {
            int left = (start + root - 1) / 2;
            int right = (root + end + 1) / 2;
            if (sb.charAt(left) == '1' || sb.charAt(right) == '1') return false;
        } 
        int left = (start + root-1) / 2;
        int right = (root + end+1) / 2;
        return dfs(start, left, root - 1) && dfs(root + 1, right, end);
    }
}

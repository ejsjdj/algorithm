class Solution {
    public int solution(int[] a) {
        int maxLen = 0;
        
        int[] arr = new int[a.length + 1];
        for (int i : a) {
            arr[i]++;
        }
        
        for (int i = 0; i <= a.length; i++) {
            if (arr[i] * 2 <= maxLen) continue;
            int cnt = 0;
            
            for (int j = 0; j < a.length-1; j++) {
                if ((a[j] == i || a[j+1] == i) && a[j] != a[j+1]) {
                    cnt += 2;
                    j++;
                }
            }
            
            maxLen = Math.max(maxLen, cnt);
        }
        
        return maxLen;
    }
}
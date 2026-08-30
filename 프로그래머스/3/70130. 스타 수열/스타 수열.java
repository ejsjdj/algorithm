class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] counter = new int[a.length + 1];
        for (int i : a) {
            counter[i]++;
        }
        
        for (int i = 0; i <= a.length; i++) {
            if (counter[i] * 2 <= answer) continue;
            int cnt = 0;
            
            for (int j = 0; j < a.length - 1; j++) {
                if ((a[j] == i || a[j + 1] == i) && a[j] != a[j + 1]) {
                    cnt += 2;
                    j += 1;
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}
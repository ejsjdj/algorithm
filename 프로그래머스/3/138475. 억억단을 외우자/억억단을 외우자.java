class Solution {
    public int[] solution(int e, int[] starts) {

        int[] answer = new int[starts.length];

        int[] divCnt = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                divCnt[j]++;
            }
        }

        int[] best = new int[e + 2];
        best[e] = e;
        
        for (int i = e; i >= 1; i--) {
            int nNum = best[i + 1];
            
            if (divCnt[i] >= divCnt[nNum]) best[i] = i;
            else best[i] = nNum;
        }

        for (int i = 0; i < starts.length; i++) {
            answer[i] = best[starts[i]];
        }

        return answer;
    }
}
class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int[] req = new int[5];
        for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
        for (int k = j + 1; k <= n; k++) {
        for (int l = k + 1; l <= n; l++) {
        for (int m = l + 1; m <= n; m++) {
            boolean flag = true;
            for (int o = 0; o < q.length; o++) {
                int cnt = 0;
                if(q[o][0] == i || q[o][1] == i || q[o][2] == i || q[o][3] == i || q[o][4] == i) cnt++;
                if(q[o][0] == j || q[o][1] == j || q[o][2] == j || q[o][3] == j || q[o][4] == j) cnt++;
                if(q[o][0] == k || q[o][1] == k || q[o][2] == k || q[o][3] == k || q[o][4] == k) cnt++;
                if(q[o][0] == l || q[o][1] == l || q[o][2] == l || q[o][3] == l || q[o][4] == l) cnt++;
                if(q[o][0] == m || q[o][1] == m || q[o][2] == m || q[o][3] == m || q[o][4] == m) cnt++;
                if(cnt != ans[o]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        }
        }
        }
        }
        return answer;
    }
}
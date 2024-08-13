class Solution {
    int[] cnt = {0, 0};

    void check(int[][] arr, int start_x, int start_y, int end_x, int end_y) {
        int now = arr[start_x][start_y];


        for (int i = start_x; i < end_x; i++) {
            for (int j = start_y; j < end_y; j++) {
                if (arr[i][j] != now) {

                    int mid_x = (start_x + end_x) / 2;
                    int mid_y = (start_y + end_y) / 2;

                    check(arr, start_x, start_y, mid_x, mid_y);
                    check(arr, mid_x, start_y, end_x, mid_y);
                    check(arr, start_x, mid_y, mid_x, end_y);
                    check(arr, mid_x, mid_y, end_x, end_y);
                    return;
                }
            }
        }
        cnt[now]++;
    }

    public int[] solution(int[][] arr) {
        check(arr, 0, 0, arr.length, arr.length);
        return cnt;
    }
}
class Solution {
    public int[] solution(int target) {

        int[][] arr = new int[target + 100][2];

        /*
            arr[i][0] = 총 던진 횟수
            arr[i][1] = 불이나 싱글을 던진 횟수
         */

        int[] single = new int[21];
        int[] doubleAndTrible = new int[40];

        int idx = 0;
        for (int i = 1; i <= 20; i++) single[i] = i;
        single[20] = 50;
        for (int n = 1; n <= 20; n++) doubleAndTrible[idx++] = 2 * n;
        for (int n = 1; n <= 20; n++) doubleAndTrible[idx++] = 3 * n;

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = Integer.MAX_VALUE / 2;
            arr[i][1] = Integer.MIN_VALUE / 2;
        }

        arr[0][0] = 0;
        arr[0][1] = 0;

        for (int i = 0; i <= target; i++) {
            // 싱글/불
            for (int next : single) {
                int score = i + next;
                if (score > target) continue;

                int cnt = arr[i][0] + 1;
                int cnt2 = arr[i][1] + 1;

                if (cnt < arr[score][0]) {
                    arr[score][0] = cnt;
                    arr[score][1] = cnt2;
                } else if (cnt == arr[score][0] && cnt2 > arr[score][1]) {
                    arr[score][1] = cnt2;
                }
            }

            // 더블/트리플
            for (int next : doubleAndTrible) {
                int score = i + next;
                if (score > target) continue;

                int cnt = arr[i][0] + 1;
                int cnt2 = arr[i][1];

                if (cnt < arr[score][0]) {
                    arr[score][0] = cnt;
                    arr[score][1] = cnt2;
                } else if (cnt == arr[score][0] && cnt2 > arr[score][1]) {
                    arr[score][1] = cnt2;
                }
            }
        }
        return new int[]{arr[target][0], arr[target][1]};
    }
}
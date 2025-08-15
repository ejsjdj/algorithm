import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long min = 0;
        long max = (long)times[times.length - 1] * n;
        long mid = (min + max) / 2;

        while (min <= max) {

            long cnt = 0;
            mid = (min + max) / 2;

            for (int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }

            if (cnt >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }
}

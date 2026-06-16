class Solution {
    public int solution(int[] cookie) {
        int max = 0;

        for (int m = 0; m < cookie.length - 1; m++) {

            int ldx = m;
            int rdx = m + 1;
            int lsum = cookie[ldx];
            int rsum = cookie[rdx];

            while (ldx >= 0 && rdx < cookie.length) {

                if (lsum == rsum) {
                    max = Math.max(lsum, max);
                }

                if (lsum <= rsum) {
                    ldx--;
                    if (ldx >= 0) {
                        lsum += cookie[ldx];
                    }
                } else {
                    rdx++;
                    if (rdx < cookie.length) {
                        rsum += cookie[rdx];
                    }
                }
            }
        }
        return max;
    }
}
class Solution {
    public long solution(int w, int h) {
        long gcd = gcd(w, h);
        return (long)w * h - (w + h - gcd);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
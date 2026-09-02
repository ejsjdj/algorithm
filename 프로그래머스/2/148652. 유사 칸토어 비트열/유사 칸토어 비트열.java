class Solution {
    public int solution(int n, long l, long r) {
        long result = count(n, r) - count(n, l - 1);
        return (int) result;
    }
    
    private long count(int n, long x) {
        if (x <= 0) return 0;
        if (n == 0) return 1;
        
        long size = 1;
        for (int i = 0; i < n - 1; i++) {
            size *= 5;
        }
        
        long q = x / size;
        long rem = x % size;
        
        long cnt = 1;
        for (int i = 0; i < n - 1; i++) {
            cnt *= 4;
        }
        
        if (q < 2) {
            return q * cnt + count(n - 1, rem);
        } else if (q == 2) {
            return 2 * cnt;
        } else {
            return (q - 1) * cnt + count(n - 1, rem);
        }
    }
}

// 0 : 1
// 1 : 11011
// 2 : 11011 11011 00000 11011 11011
// 3 : 
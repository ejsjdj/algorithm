class Solution {
    public int solution(int n) {
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);
        for (int i = 2; i <= n; i++) {
        	int c = (a + b) % 1234567;
        	a = b;
        	b = c;
        }
        return (int)b % 1234567;
    }
}
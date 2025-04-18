import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        long[] factorial = new long[n];
        
        
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        k--; 
        
        for (int i = 0; i < n; i++) {
            int index = (int) (k / factorial[n - 1 - i]);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k %= factorial[n - 1 - i];
        }
        
        return answer;
    }
}
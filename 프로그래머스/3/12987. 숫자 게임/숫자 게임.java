import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0;
        int b = 0;
        
        while (a < A.length && b < B.length) {
            if (B[b] > A[a]) {
                answer++; // B의 요소가 A의 요소보다 클 때 점수 증가
                a++; // A의 다음 요소로 이동
            }
            b++; // B의 다음 요소로 이동
        }
        
        return answer;
    }
}
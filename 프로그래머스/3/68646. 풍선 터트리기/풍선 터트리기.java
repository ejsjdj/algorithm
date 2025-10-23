class Solution {
    public int solution(int[] a) {
        int answer = a.length;
        
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        
        left[0] = a[0];
        right[a.length - 1] = a[a.length - 1];
        
        for (int i = 1; i < a.length; i++) {
        		left[i] = Math.min(left[i-1], a[i]);
        		right[a.length - 1 - i] = Math.min(right[a.length - i], a[a.length - i - 1]);
        }
        
        for (int i = 0; i < a.length; i++) {
        		if (a[i] > left[i] && a[i] > right[i]) {
                    answer--;
                }
        }
        
        return answer;
    }
}
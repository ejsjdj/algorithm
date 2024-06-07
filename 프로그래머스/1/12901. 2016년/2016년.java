class Solution {
    public String solution(int a, int b) {
        
        int[] len = {0,31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        			// 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        return day[((len[ a - 1 ] + b) - 1) % 7];
    }
}
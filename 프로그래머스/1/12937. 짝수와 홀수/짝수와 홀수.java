class Solution {
    public String solution(int num) {
    	if (num < 0) num = -num;
        return num % 2 == 1 ? "Odd" : "Even";
    }
}
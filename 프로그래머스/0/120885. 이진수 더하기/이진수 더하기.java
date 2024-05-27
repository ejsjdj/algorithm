class Solution {
    public String solution(String bin1, String bin2) {
        int num1 = Integer.parseInt(bin1, 2);
        int num2 = Integer.parseInt(bin2, 2);
        String answer = Integer.toBinaryString(num1 + num2);
        
        return answer;
    }
}
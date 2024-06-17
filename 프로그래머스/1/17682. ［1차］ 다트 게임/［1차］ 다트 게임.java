class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int index = -1;
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)) {
                index++;
                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    scores[index] = 10;
                    i++;
                } else {
                    scores[index] = c - '0';
                }
            } else if (c == 'S') {
                scores[index] = (int) Math.pow(scores[index], 1);
            } else if (c == 'D') {
                scores[index] = (int) Math.pow(scores[index], 2);
            } else if (c == 'T') {
                scores[index] = (int) Math.pow(scores[index], 3);
            } else if (c == '*') {
                scores[index] *= 2;
                if (index > 0) {
                    scores[index - 1] *= 2;
                }
            } else if (c == '#') {
                scores[index] *= -1;
            }
        }
        
        return scores[0] + scores[1] + scores[2];
    }
}
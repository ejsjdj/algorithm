class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for (String b : babbling) {
            String modified = b;
            for (String word : words) {
                modified = modified.replace(word, " ");
            }
            modified = modified.trim();
            if (modified.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
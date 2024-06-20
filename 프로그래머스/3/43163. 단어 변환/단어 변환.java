import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) {
            return 0;
        }
        
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(begin, 0));
        
        while (!queue.isEmpty()) {
            WordNode current = queue.poll();
            String currentWord = current.word;
            int currentLevel = current.level;
            
            if (currentWord.equals(target)) {
                return currentLevel;
            }
            
            char[] wordArray = currentWord.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                char originalChar = wordArray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (wordArray[i] != c) {
                        wordArray[i] = c;
                        String newWord = String.valueOf(wordArray);
                        if (wordSet.contains(newWord)) {
                            queue.add(new WordNode(newWord, currentLevel + 1));
                            wordSet.remove(newWord);
                        }
                    }
                }
                wordArray[i] = originalChar;
            }
        }
        
        return 0;
    }
    
    class WordNode {
        String word;
        int level;
        
        WordNode(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}
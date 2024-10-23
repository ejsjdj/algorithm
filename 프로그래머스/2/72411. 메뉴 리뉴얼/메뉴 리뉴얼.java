import java.util.*;

class Solution {
    
    HashMap<String, Integer> hm = new HashMap<>();
    
    void DFS(boolean[] arr, int idx, StringBuilder str) {
        if (idx == arr.length) return;
        
        DFS(arr, idx + 1, str);
        
        if (arr[idx]) {
            str.append((char)('A' + idx));
            String combination = str.toString();
            hm.put(combination, hm.getOrDefault(combination, 0) + 1);
            DFS(arr, idx + 1, str);
            str.deleteCharAt(str.length() - 1); // 백트래킹
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        
        for (String order : orders) {
            boolean[] arr = new boolean[26];
            
            for (char c : order.toCharArray()) {
                arr[c - 'A'] = true;
            }
            
            DFS(arr, 0, new StringBuilder());
        }
        
        for (int courseLength : course) {
            int maxFrequency = 2; // 최소 두 번 이상 주문된 조합만 고려
            List<String> candidates = new ArrayList<>();
            
            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                String combination = entry.getKey();
                int frequency = entry.getValue();
                
                if (combination.length() == courseLength) {
                    if (frequency > maxFrequency) {
                        maxFrequency = frequency;
                        candidates.clear();
                        candidates.add(combination);
                    } else if (frequency == maxFrequency) {
                        candidates.add(combination);
                    }
                }
            }
            
            answerList.addAll(candidates);
        }
        
        Collections.sort(answerList); // 사전순 정렬
        return answerList.toArray(new String[0]);
    }
}
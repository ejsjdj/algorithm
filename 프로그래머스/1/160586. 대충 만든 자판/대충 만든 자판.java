import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> hm = new HashMap<>();


        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);

                hm.put(c, Math.min(hm.getOrDefault(c, Integer.MAX_VALUE), j + 1));
            }
        }

        // 타겟 문자열 처리
        for (int i = 0; i < targets.length; i++) {
            int total = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (hm.containsKey(c)) {
                    total += hm.get(c);
                } else {
                    total = -1;
                    break; 
                }
            }
            answer[i] = total;
        }
        return answer;
    }
}
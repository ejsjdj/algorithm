import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
    
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i + 1);
        }
        
        for(int i = 0; i < callings.length; i++) {
            int idx = map.get(callings[i]) - 1;
            
            players[idx] = players[idx-1]; 
            players[idx-1] = callings[i];
            
            map.put(players[idx], idx + 1);
            map.put(callings[i], idx);
        }
        
        return players;
    }
}
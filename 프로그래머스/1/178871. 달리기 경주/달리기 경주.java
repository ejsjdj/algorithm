import java.util.HashMap;

class Solution {
	
	int getIndex(int[] players_Integer, int calling) {
		
		for (int i = 0; i < players_Integer.length; i++) {
			if (players_Integer[i] == calling) return i;
		}
		
		return 0;
	}
	
	int[] play(int[] players_Integer, int[] callings_Integer) {
		
		for (int i = 0; i < callings_Integer.length; i++) {
			int idx = getIndex(players_Integer, callings_Integer[i]);
			int tmp = players_Integer[idx];
			players_Integer[idx] = players_Integer[idx-1];
			players_Integer[idx-1] = tmp;
		}
		return players_Integer;
	}
	
    public String[] solution(String[] players, String[] callings) {
    	
    	// 배열의 각 값을 숫자에 대응시킨다.
    	// HashSet에 찾을수있도록 값을 저장시킨다.
    	// calling에 따라 순위를 조정한다.
    	// 결과값을 숫자에서 String 으로 다시 변환한다.
    	// 결과를 출력한다.
    	
    	HashMap<Integer, String> hm_Integer = new HashMap<>();
    	HashMap<String, Integer> hm_String = new HashMap<>();
    	
    	for (int i = 0; i < players.length; i++) {
    		hm_Integer.put(i, players[i]);
    		hm_String.put(players[i], i);
    	}
    	
    	int[] players_Integer = new int[players.length];
    	int[] callings_Integer = new int[callings.length];
    	
    	for (int i = 0; i < players_Integer.length; i++) {
    		players_Integer[i] = i;
    	}
    	
    	for (int i = 0; i < callings_Integer.length; i++) {
    		callings_Integer[i] = hm_String.get(callings[i]);
    	}
    	int[] result = play(players_Integer, callings_Integer);
    	
        String[] answer = new String[result.length];
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = hm_Integer.get(result[i]);
        }
        
        return answer;
    }
}
class Solution {
	
	int[] picks;
	String[] minerals;
	int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        this.picks = picks;
        this.minerals = minerals;
    		
        if (picks[0] > 0) {
			picks[0]--;
			DFS("diamond", 0, 0, 0);
			picks[0]++;
		}
		if (picks[1] > 0) {
			picks[1]--;
			DFS("iron", 0, 0, 0);
			picks[1]++;
		}
		if (picks[2] > 0) {
			picks[2]--;
			DFS("stone", 0, 0, 0);
			picks[2]++;
		}
        return answer;
    }
    
    void DFS(String pick, int depth, int fatigue, int cnt) {
    		
    		// 종료조건
		if (depth == minerals.length) {
			answer = Math.min(fatigue, answer);
			return;
		}
	    	// 피로도 계선
	    	if (pick.endsWith("diamond")) {
	    		fatigue += 1;
	    	} else if (pick.equals("iron")) {
	    		if (minerals[depth].equals("diamond")) fatigue += 5;
	    		else fatigue += 1;
	    	} else if (pick.equals("stone")) {
	    		if (minerals[depth].equals("diamond")) fatigue += 25;
	    		else if (minerals[depth].equals("iron")) fatigue += 5;
	    		else fatigue += 1;
	    	}
	    	depth += 1;
	    	cnt += 1;

	    	// 종료조건
    		if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0 && cnt == 5) {
    			answer = Math.min(fatigue, answer);
    			return;
    		}
    		
    		
    		if (cnt % 5 == 0) {
    			if (picks[0] > 0) {
    				picks[0]--;
    				DFS("diamond", depth, fatigue, 0);
    				picks[0]++;
    			}
    			if (picks[1] > 0) {
    				picks[1]--;
    				DFS("iron", depth, fatigue, 0);
    				picks[1]++;
    			}
    			if (picks[2] > 0) {
    				picks[2]--;
    				DFS("stone", depth, fatigue, 0);
    				picks[2]++;
    			}    			
    		}
    		
    		else {
    			DFS(pick, depth, fatigue, cnt);
    		}
    	
    }
}

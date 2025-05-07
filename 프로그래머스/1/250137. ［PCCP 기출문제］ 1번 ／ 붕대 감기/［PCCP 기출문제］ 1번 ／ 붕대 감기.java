class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int last = 0;
        int max = health;
        int answer = 0;
        for (int i = 0; i < attacks.length; i++){
        	
        	int time = attacks[i][0] - last;
        	last = attacks[i][0] + 1;
        	health += bandage[1] * time;
        	health += time / bandage[0] * bandage[2];
        	health = Math.min(health, max);
        	health -= attacks[i][1];
        	if (health <= 0) return -1;
        	else answer = health;
        }
        
        return answer;
    }
}
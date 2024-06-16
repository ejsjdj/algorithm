class Solution {
	int N;
	int cnt = 0;
	
	void targetNum(int[] numbers, int target,int now, int jarisu) {
		if (jarisu == N) {
			if (now == target) {
				cnt++;
			}
			return;				
		}
		
		targetNum(numbers, target, now + numbers[jarisu], jarisu+1);
		targetNum(numbers, target, now - numbers[jarisu], jarisu+1);
		
	}
	
    public int solution(int[] numbers, int target) {
        int jarisu = 0;
        int now = 0; 
        N = numbers.length;
        targetNum(numbers, target, now + numbers[jarisu], jarisu+1);
		targetNum(numbers, target, now - numbers[jarisu], jarisu+1);
        
        return cnt;
    }
}
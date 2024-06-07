class Solution {
	boolean isPrime(int num) {
		boolean flag = true;
		
		for (int i = 2; i < num - 1; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
        	for (int j = i + 1; j < nums.length - 1; j++) {
        		for (int k = j + 1; k < nums.length; k++) {
        			if (isPrime(nums[i] + nums[j] + nums[k])) answer += 1;
        		}
        	}
        }

        return answer;
    }
}
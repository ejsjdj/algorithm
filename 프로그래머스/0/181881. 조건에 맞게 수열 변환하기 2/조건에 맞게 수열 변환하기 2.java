class Solution {
	public int solution(int[] arr) {
		int[] arr1 = arr.clone();
		int[] arr2 = arr.clone();
		int answer = 0;
		while (true) {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] >= 50 && arr[i] % 2 == 0) {
					arr2[i] = arr1[i] / 2;
				} else if (arr1[i] < 50 && arr[i] % 2 == 1) {
					arr2[i] = arr1[i] * 2 + 1;
				}
			}
            
			boolean flag = true;
			for (int i = 0 ; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					flag = false;
					break;
				}
			}
			arr1 = arr2.clone();
			
			if (flag) return answer;
			answer ++;
			
		}
	}
}
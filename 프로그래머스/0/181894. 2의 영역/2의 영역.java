class Solution {
	public int[] solution(int[] arr) {
		int first = 0;
		int last = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				first = i;
				break;
			}
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 2) {
				last = i;
				break;
			}
		}

		int[] answer = new int[last - first + 1];

		for (int i = 0; i <= last - first; i++) {
			answer[i] = arr[first + i];
		}
		
		if (answer[0] != 2) answer[0] = -1;

//		for (int i = 0; i < answer.length; i++) {
//			System.out.print(answer[i] + " ");
//		}
		
		return answer;
	}
}
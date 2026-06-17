class Solution {
	public int solution(int[] rank, boolean[] attendance) {
		int[] arrIdx = new int[3];
		for (int i = 0; i < 3; i++) {
			arrIdx[i] = Integer.MAX_VALUE;
		}

		int[] score = new int[3];
		for (int i = 0; i < score.length; i++) {
			score[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < attendance.length; i++) {
			if (attendance[i] == true) {
				if (score[0] > rank[i]) {
					score[2] = score[1];
					score[1] = score[0];
					score[0] = rank[i];
					arrIdx[2] = arrIdx[1];
					arrIdx[1] = arrIdx[0];
					arrIdx[0] = i;

				} else if (score[1] > rank[i]) {
					score[2] = score[1];
					score[1] = rank[i];
					arrIdx[2] = arrIdx[1];
					arrIdx[1] = i;

				} else if (score[2] > rank[i]) {
					score[2] = rank[i];
					arrIdx[2] = i;
				}
			}

		}

		int answer = 10000 * arrIdx[0] + 100 * arrIdx[1] + arrIdx[2];
		return answer;
	}
}
import java.util.Arrays;

class Solution {
	public int solution(int distance, int[] rocks, int n) {
		// 거리의 최소값 중 가장 큰 값 구하기
		int minValue = Integer.MIN_VALUE / 2;

		Arrays.sort(rocks);
		
		// 이진탐색 left = 0
		// right = distance 로 시작
		int left = 0;
		int right = distance;


		while (left <= right) {
			// 중간값을 달성 가능한 지 확인
			int last = 0;
			int mid = (left + right) / 2;
			int cnt = 0;
			
			for (int i = 0; i < rocks.length; i++) {
				
				// 현재 바위의 위치와 마지막 바위의 위치의 차가 mid 보다 작다면 해당바위는 제거한다.
				if (rocks[i] - last < mid) {
					// 제거한 횟수 증가
					cnt = cnt + 1;
				}

				else {
					// 현재 바위 위치와 마지막 바위의 위치의 차가 mid 보다 크거나 같다면 통과
					// last 의 위치를 갱신한다.
					last = rocks[i];
				}
				
			}

			if (distance - last < mid) cnt = cnt + 1;
			// 목표값을 달성하기위해 바위를 뺀 개수가 n 개 이하일 경우
			// 답을 적는다.
			if (cnt <= n) {
				// 최소값의 최대값으로 설정된 mid 가 n 개 이하의 바위를 제거해도 통과 되는 경우
				// 결과를 저장하고 최소값의 최대값이 더 높은 값을 체크
				minValue = Math.max(mid, minValue);
				left = mid + 1;
			} else {
				
				right = mid - 1;
			}

		}

		return minValue;
		
	}
}
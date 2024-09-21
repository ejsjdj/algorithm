import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int length = friends.length;	// 회원의 수
        int[] result = new int[length];	// 정답을 계산하기 위해 선언한 배열
        
        // 캐릭터의 이름을 숫자에 매핑할 HashMap을 선언하고 input
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < friends.length; i++) hm.put(friends[i], i);
        
        // 선물을 주고받은 횟수를 나타낼 2차원 행렬선언하고 gifts 배열을 반복실행
        // 자기자신을 가르키는 값에는 선물지수를 입력
        int[][] cnt = new int[friends.length][friends.length];
        for (int i = 0; i < gifts.length; i++) {
        	int giver = hm.get(gifts[i].split(" ")[0]);
        	int receiver = hm.get(gifts[i].split(" ")[1]);
        	
        	cnt[giver][receiver]++;	// 보낸결과를 반영
        	cnt[giver][giver]++;	// giver 의 선물지수 증가
        	cnt[receiver][receiver]--; // receiver 의 선물지수 감소
        	
        }
        
        // 결과를 연산
        for (int i = 0; i < length; i++) {
        	for (int j = 0; j < length; j++) {
        		
        		// i 가 j 에게 준 횟수가 j 가 i 에게 준 횟수가 더 많으면 result 배열에 기록
        		if (cnt[i][j] > cnt[j][i]) result[i]++;
        		
        		// 두 사람이 선물을 주고 받은 횟수가 같으면 선물지수를 비교한 후에 차이가 있으면 결과를 반영
        		else if (cnt[i][j] == cnt[j][i]) if (cnt[i][i] > cnt[j][j]) result[i]++;
        	}
        }
        for (int i = 0; i < length; i++) {
        	if (answer < result[i]) answer = result[i];
        }
        
        return answer;
    }
}
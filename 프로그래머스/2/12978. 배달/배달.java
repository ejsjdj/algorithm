import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[] result = new int[N+1];
        int[][] connect = new int[N+1][N+1];
        
        for (int i = 1; i <= N; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[1] = 0;
        
        for (int i = 0; i < road.length; i++) {
        	int a = road[i][0];
        	int b = road[i][1];
        	int c = road[i][2];
        	
        	if (connect[a][b] == 0 || connect[a][b] > c) {
        		connect[a][b] = c;
        		connect[b][a] = c;
        	}
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (connect[now][i] != 0) {
                    int newDist = result[now] + connect[now][i];

                    // 더 짧은 경로 발견 시 거리 업데이트
                    if (newDist < result[i]) {
                        result[i] = newDist;
                        queue.add(i); // 거리 업데이트 후 큐에 추가
                    }
                }
            }
        }
        for (int i = 1; i < result.length; i++) {
        	if (result[i] <= K) {
        		answer++;
        	}
        }
        return answer;
    }
}
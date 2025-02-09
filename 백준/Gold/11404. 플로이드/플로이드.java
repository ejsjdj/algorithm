import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력: 도시와 버스의 개수
        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        // 거리 배열 초기화
        int[][] distance = new int[cityCount + 1][cityCount + 1];
        final int INF = Integer.MAX_VALUE / 2; // 무한대 값 (오버플로우 방지)

        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                if (i == j) distance[i][j] = 0; // 자기 자신으로 가는 경로는 0
                else distance[i][j] = INF;     // 초기값은 무한대
            }
        }

        // 입력: 버스 정보 처리
        for (int i = 0; i < busCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 최소 비용만 저장
            distance[startCity][endCity] = Math.min(distance[startCity][endCity], cost);
        }

        // 플로이드-워셜 알고리즘: 모든 경로에 대한 최소 비용 계산
        for (int via = 1; via <= cityCount; via++) {       // 경유 도시
            for (int from = 1; from <= cityCount; from++) { // 출발 도시
                for (int to = 1; to <= cityCount; to++) {   // 도착 도시
                    if (distance[from][to] > distance[from][via] + distance[via][to]) {
                        distance[from][to] = distance[from][via] + distance[via][to];
                    }
                }
            }
        }

        // 결과 출력: 연결되지 않은 경우 0 출력
        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                if (distance[i][j] == INF) sb.append(0).append(" ");
                else sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
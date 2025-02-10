import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력: 도시와 버스의 개수
        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        // 거리 배열 초기화
        Distance[][] distances = initializeDistances(cityCount);

        // 입력: 버스 정보 처리
        for (int i = 0; i < busCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            updateDistance(distances, startCity, endCity, cost);
        }

        // 플로이드-워셜 알고리즘 실행
        floydWarshall(distances, cityCount);

        // 결과 출력
        printResults(distances, cityCount, sb);

        System.out.println(sb);
    }

    // 거리 배열 초기화 메서드
    private static Distance[][] initializeDistances(int cityCount) {
        final int INF = Integer.MAX_VALUE / 2; // 무한대 값 (오버플로우 방지)
        Distance[][] distances = new Distance[cityCount + 1][cityCount + 1];

        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                distances[i][j] = new Distance();
                if (i == j) {
                    distances[i][j].cost = 0; // 자기 자신으로 가는 경로는 0
                } else {
                    distances[i][j].cost = INF; // 초기값은 무한대
                }
            }
        }
        return distances;
    }

    // 거리 업데이트 메서드
    private static void updateDistance(Distance[][] distances, int startCity, int endCity, int cost) {
        if (distances[startCity][endCity].cost > cost) {
            distances[startCity][endCity].cost = cost;
            distances[startCity][endCity].list.clear();
            distances[startCity][endCity].list.add(startCity);
            distances[startCity][endCity].list.add(endCity);
        }
    }

    // 플로이드-워셜 알고리즘 메서드
    private static void floydWarshall(Distance[][] distances, int cityCount) {
        for (int via = 1; via <= cityCount; via++) {       // 경유 도시
            for (int from = 1; from <= cityCount; from++) { // 출발 도시
                for (int to = 1; to <= cityCount; to++) {   // 도착 도시
                    if (distances[from][to].cost > distances[from][via].cost + distances[via][to].cost) {
                        distances[from][to].cost = distances[from][via].cost + distances[via][to].cost;

                        // 경로 갱신
                        List<Integer> newPath = new ArrayList<>(distances[from][via].list);
                        newPath.addAll(distances[via][to].list.subList(1, distances[via][to].list.size()));
                        distances[from][to].list = newPath;
                    }
                }
            }
        }
    }

    // 결과 출력 메서드
    private static void printResults(Distance[][] distances, int cityCount, StringBuilder sb) {
        final int INF = Integer.MAX_VALUE / 2;

        // 최소 비용 출력
        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                if (distances[i][j].cost == INF) sb.append(0).append(" ");
                else sb.append(distances[i][j].cost).append(" ");
            }
            sb.append("\n");
        }

        // 경로 출력
        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                if (distances[i][j].cost == INF) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(distances[i][j].list.size()).append(" ");
                    for (int k : distances[i][j].list) {
                        sb.append(k).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
    }
}

// 거리와 경로를 저장하는 클래스
class Distance {
    int cost;
    List<Integer> list;

    public Distance() {
        this.cost = Integer.MAX_VALUE / 2; // 초기값은 무한대
        this.list = new ArrayList<>();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, sCity, eCity; // N: 도시 수, M: 교통수단 수, sCity: 시작 도시, eCity: 도착 도시
	static long distance[], cityMoney[]; // distance: 각 도시까지 벌 수 있는 최대 돈, cityMoney: 각 도시에서 벌 수 있는 돈
	static Edge edges[]; // 교통수단 정보를 저장하는 배열

	public static void main(String[] args) throws IOException {
		// 첫 번째 줄 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 수
		sCity = Integer.parseInt(st.nextToken()); // 시작 도시
		eCity = Integer.parseInt(st.nextToken()); // 도착 도시
		M = Integer.parseInt(st.nextToken()); // 교통수단 수
		
		// 배열 초기화
		edges = new Edge[M]; // 교통수단 정보를 저장할 배열
		distance = new long[N]; // 각 도시까지의 최대 돈을 저장할 배열
		cityMoney = new long[N]; // 각 도시에서 벌 수 있는 돈 배열
		Arrays.fill(distance, Long.MIN_VALUE); // 초기값을 최소값으로 설정 (아직 방문하지 않은 상태)
		
		// 교통수단 정보 입력 처리
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 출발 도시
			int end = Integer.parseInt(st.nextToken());   // 도착 도시
			int price = Integer.parseInt(st.nextToken()); // 비용
			edges[i] = new Edge(start, end, price);       // 간선 정보 저장
		}
		
		// 각 도시에서 벌 수 있는 돈 입력 처리
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cityMoney[i] = Long.parseLong(st.nextToken());
		}
		
		// 시작 도시의 초기 값을 설정 (시작점에서 벌 수 있는 돈)
		distance[sCity] = cityMoney[sCity];
		
		// 변형된 벨만-포드 알고리즘 수행 (최대 N + 100번 반복)
		for (int i = 0; i <= N + 100; i++) {
			for (int j = 0; j < M; j++) {
				int start = edges[j].start; // 간선의 출발 도시
				int end = edges[j].end;     // 간선의 도착 도시
				int price = edges[j].price; // 간선의 비용
				
				// 출발 노드가 아직 방문되지 않았다면 스킵
				if (distance[start] == Long.MIN_VALUE) continue;
				
				// 출발 노드가 양수 사이클에 연결된 경우, 도착 노드도 양수 사이클로 설정
				else if (distance[start] == Long.MAX_VALUE)
					distance[end] = Long.MAX_VALUE;
				
				// 더 많은 돈을 벌 수 있는 새로운 경로가 발견되었을 때 업데이트
				else if (distance[end] < distance[start] + cityMoney[end] - price) {
					distance[end] = distance[start] + cityMoney[end] - price;
					
					// N-1번 반복 이후에도 업데이트가 발생하면 양수 사이클로 간주
					if (i >= N - 1) distance[end] = Long.MAX_VALUE;
				}
			}
		}
		
		// 결과 출력 처리
		if (distance[eCity] == Long.MIN_VALUE) 
			System.out.println("gg"); // 도착 도시에 도달할 수 없는 경우
		
		else if (distance[eCity] == Long.MAX_VALUE) 
			System.out.println("Gee"); // 양수 사이클에 연결되어 돈을 무한히 벌 수 있는 경우
		
		else 
			System.out.println(distance[eCity]); // 도착 도시에 도달했을 때 벌 수 있는 최대 금액 출력
	}
}

// 간선 정보를 저장하는 클래스 정의
class Edge {
	int start, end, price; // 출발 도시, 도착 도시, 비용
	
	public Edge(int start, int end, int price) {
		this.start = start;
		this.end = end;
		this.price = price;
	}
}
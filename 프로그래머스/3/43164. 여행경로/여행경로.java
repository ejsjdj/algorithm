import java.util.Arrays;

class Solution {
	String result = "";
	boolean[] visited;
    public String[] solution(String[][] tickets) {
    	
    	Arrays.sort(tickets, (o1, o2) -> o2[1].compareTo(o1[1]));
    	
    	visited = new boolean[tickets.length];
    	
    	DFS("ICN", "ICN", 0, tickets);
    	String[] answer = result.split(" ");
        return answer;
    }

	void DFS(String now, String word, int i, String[][] tickets) {
		if (i == tickets.length) result = (word);
		for (int j = 0; j < tickets.length; j++) {
			if (tickets[j][0].equals(now) && visited[j] == false) { // 티켓의 출발지가 같고, 그 티켓이 아직 사용되지 않았다면
				visited[j] = true;									// 사용처리
				DFS(tickets[j][1], word + " " + tickets[j][1], i + 1, tickets);
				visited[j] = false;									// 해당 경로가 틀렸을 경우 다시 방문하지 않음 처리
			} 
		}
	}
}
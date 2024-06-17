class Solution {
	boolean[] visited;
	int cnt = 0;
	void DFS(int v, int[][] computers) {
		if (visited[v] == true) return;
		else {
			visited[v] = true;
			cnt++;
		}
		for (int i = 0; i < computers.length; i++) {
			if (visited[i] != true && computers[v][i] == 1) {
				DFS(i, computers);
			}
		}
	}
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
        	DFS(i, computers);
        	if (cnt != 0) answer++;
        	cnt = 0;
        }
        return answer;
    }
}
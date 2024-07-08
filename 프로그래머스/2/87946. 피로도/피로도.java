class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return DFS(k, dungeons, visited, 0);
    }

    private int DFS(int k, int[][] dungeons, boolean[] visited, int cnt) {
        int max = cnt;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k && k - dungeons[i][1] >= 0) {
                visited[i] = true;
                max = Math.max(max, DFS(k - dungeons[i][1], dungeons, visited, cnt + 1));
                visited[i] = false;
            }
        }
        return max;
    }
}
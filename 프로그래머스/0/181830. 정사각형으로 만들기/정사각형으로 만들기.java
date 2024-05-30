class Solution {
    public int[][] solution(int[][] arr) {
        int width = arr[0].length;
        int height = arr.length;
        int num = Math.max(width, height);
        
        int[][] answer = new int[num][num];
        
        for (int i = 0; i < height; i++) {
        	for (int j = 0; j < width; j++) {
        		answer[i][j] = arr[i][j];
        	}
        }
        
        return answer;
    }
}
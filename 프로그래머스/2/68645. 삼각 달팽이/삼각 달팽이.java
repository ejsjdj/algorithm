class Solution {

    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        
        int[][] arr = new int[n][];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i+1];
        }
        
        int x = -1, y = 0; // 시작 위치 조정
        int num = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) { // 아래로 
                    x++;
                } else if (i % 3 == 1) { // 오른쪽으로 
                    y++;
                } else if (i % 3 == 2) { // 대각선 위로 
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
        
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[k++] = arr[i][j];
            }
        }
        
        return answer;
    }
}
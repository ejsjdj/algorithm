class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int[] result = new int[queries.length];
        
        for (int i = 0, num = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            result[i] = rotate(matrix, queries[i]);
        }
        
        
        return result;
    }

    private int rotate(int[][] matrix, int[] query) {
        int row1 = query[0] - 1;
        int col1 = query[1] - 1;
        int row2 = query[2] - 1;
        int col2 = query[3] - 1;
        
        int temp = matrix[row1][col1];
        int min = temp;
        
        for (int i = row1; i < row2; i++) {
        	matrix[i][col1] = matrix[i+1][col1];
        	min = Math.min(min, matrix[i][col1]);
        }
        for (int i = col1; i < col2; i++) {
        	matrix[row2][i] = matrix[row2][i+1];
        	min = Math.min(min, matrix[row2][i]);
        }
        for (int i = row2; i > row1; i--) {
        	matrix[i][col2] = matrix[i-1][col2];
        	min = Math.min(min, matrix[i][col2]);
        }
        for (int i = col2; i > col1 + 1; i--) {
        	matrix[row1][i] = matrix[row1][i-1];
        	min = Math.min(min, matrix[row1][i]);
        }
        matrix[row1][col1+1] = temp;
        return min;
    }
}
class Solution {
    public int solution(int[][] dots) {
        
        double[] A = {dots[0][0], dots[0][1]};
        double[] B = {dots[1][0], dots[1][1]};
        double[] C = {dots[2][0], dots[2][1]};
        double[] D = {dots[3][0], dots[3][1]};
        
        if (check(A, B) == check(C, D)) return 1;
        if (check(A, C) == check(B, D)) return 1;
        if (check(A, D) == check(B, C)) return 1;
        
        return 0;
    }
    
    double check(double[] X, double[] Y) {
    	if (X[0] - Y[0] > 0) {
    		return ((X[0] - Y[0]) / (X[1] - Y[1]));
    	} else {
    		return check(Y, X);
    	}
    }
}
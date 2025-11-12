class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        double max = (double) r2 * r2;
        double min = (double) r1 * r1;
        
        for (long i = 1; i <= r2; i++) {
        	double a = i * i;
        	double y2y2 = max - a;
        	double y1y1 = min - a;
        	
        	if (y1y1 < 0) y1y1 = 0;
        	
        	int y2 = (int) Math.sqrt(y2y2);
        	double y1 = Math.sqrt(y1y1);

        	double gap = y2 - y1;
        	
        	answer = answer + (int) gap + 1;
        	
        }
        
        return answer * 4;
    }
}
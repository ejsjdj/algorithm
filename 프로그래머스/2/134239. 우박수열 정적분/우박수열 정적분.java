import java.util.ArrayList;
import java.util.List;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        
        answer = new double[ranges.length];
        List<Double> list = new ArrayList<>();
        list.add(0.0);
        System.out.println(0 + " " + 0);
        int cnt = 1;
        while (k != 1) {
        		double last = k;
        		if (k % 2 == 0) k = k / 2;
        		else k = 3 * k + 1;
        		double result = (k + last)/2;
        		list.add(result + list.get(list.size() - 1));
        		System.out.println(cnt++ + " " + list.get(list.size() - 1));
        }
        
        for (int i = 0; i < ranges.length; i++) {
        		int left = ranges[i][0];
        		int right = ranges[i][1];
        		int n = list.size() - 1;
        		right = n + right;
        		if (right < left) {
        			answer[i] = -1;
        			continue;
        		}
        		double result = list.get(right) - list.get(left);
        		System.out.println(list.get(right) + " " + list.get(left) + " " + result);
        		System.out.println();
        		answer[i] = result;
        }
        
        return answer;
    }
}

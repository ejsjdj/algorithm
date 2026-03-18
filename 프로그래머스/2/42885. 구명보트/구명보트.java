import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
    	int answer = 0;
        
        Arrays.sort(people);
        
        int seohee = 0;
        int pig = people.length - 1;
        
        while (seohee <= pig) {
        	answer += 1;
        	if (people[seohee] + people[pig] <= limit) {
        		seohee++;
        		pig--;
        	} else {
        		pig--;
        	}
        }
        
        return answer;
    }
}
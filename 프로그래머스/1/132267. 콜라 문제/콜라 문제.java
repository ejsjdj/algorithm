class Solution {
	
	public int solution(int a, int b, int n) {
        int answer = 0;
        
        int my_bottle = n;
        int new_bottle = my_bottle / a * b;
        answer += new_bottle;
        int rest_bottle = my_bottle % a;
        my_bottle = new_bottle + rest_bottle;
         while (my_bottle >= a) {
        	 new_bottle = my_bottle / a * b;
             rest_bottle = my_bottle % a;
             answer += new_bottle;
             my_bottle = new_bottle + rest_bottle;
         }
        return answer;
    }
}
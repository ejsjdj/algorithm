class Solution {
    public int[] solution(long n) {
    	
    	String string_num = String.valueOf(n);
        
    	int[] arr= new int[string_num.length()];
    	
    	for (int i = 0; i < string_num.length(); i++) {
    		arr[i] = string_num.charAt(string_num.length() - i - 1) - '0';
    	}
        
        return arr;
    }
}
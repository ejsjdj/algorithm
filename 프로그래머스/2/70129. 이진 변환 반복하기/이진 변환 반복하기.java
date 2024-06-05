class Solution {
    public int[] solution(String s) {
        
        int zeroCnt = 0;
        int tryCnt = 0;
        
        while (!s.equals("1")) {
        	int sLength = s.length();
        	int newLength = s.replace("0", "").length();
        	
        	zeroCnt += sLength - newLength;
        	s = Integer.toBinaryString(newLength);
        	
        	tryCnt += 1;
        }
        
        return new int[] {tryCnt, zeroCnt};
    }
}
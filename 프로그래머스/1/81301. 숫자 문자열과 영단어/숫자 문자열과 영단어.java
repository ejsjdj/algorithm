import java.util.HashMap;

class Solution {
    public int solution(String s) {
    	
    	HashMap<String, String> hashMap = new HashMap<>();
    	hashMap.put("zero", "0");
    	hashMap.put("one", "1");
    	hashMap.put("two", "2");
    	hashMap.put("three", "3");
    	hashMap.put("four", "4");
    	hashMap.put("five", "5");
    	hashMap.put("six", "6");
    	hashMap.put("seven", "7");
    	hashMap.put("eight", "8");
    	hashMap.put("nine", "9");
    	
    	s = s.replaceAll("zero", hashMap.get("zero"));
    	s = s.replaceAll("one", hashMap.get("one"));
    	s = s.replaceAll("two", hashMap.get("two"));
    	s = s.replaceAll("three", hashMap.get("three"));
    	s = s.replaceAll("four", hashMap.get("four"));
    	s = s.replaceAll("five", hashMap.get("five"));
    	s = s.replaceAll("six", hashMap.get("six"));
    	s = s.replaceAll("seven", hashMap.get("seven"));
    	s = s.replaceAll("eight", hashMap.get("eight"));
    	s = s.replaceAll("nine", hashMap.get("nine"));
    	
        int answer = Integer.parseInt(s);
        return answer;
    }
}

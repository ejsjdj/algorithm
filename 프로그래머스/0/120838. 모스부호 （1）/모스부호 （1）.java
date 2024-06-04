import java.util.HashMap;
import java.util.Map;

class Solution {
	public String solution(String letter) {
        String answer = "";
        Map<String, String> map = new HashMap<>();
        
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        

        for (int i = 0; i < morse.length; i++) {
        	map.put(morse[i], Character.toString(i+97));
        }

        String[] letterArray = letter.split(" ");
        
        for (String c : letterArray) {
        	answer += map.get(c);
        }
        return answer;
    }
}
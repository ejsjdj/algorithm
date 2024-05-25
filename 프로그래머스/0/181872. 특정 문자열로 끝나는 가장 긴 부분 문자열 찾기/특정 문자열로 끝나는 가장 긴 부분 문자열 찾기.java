class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        System.out.println(myString.lastIndexOf(pat));
        answer = myString.substring(0,myString.lastIndexOf(pat) + pat.length());
        
        return answer;
    }
}
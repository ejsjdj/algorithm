class Solution {
    public String solution(String new_id) {
        String step1 = new_id.toLowerCase();
        
        String step2 = "";
        for (int i = 0; i < step1.length(); i++) {
            char now = step1.charAt(i);
            if ((now >= 'a' && now <= 'z') || (now >= '0' && now <= '9') || now == '-' || now == '_' || now == '.') {
                step2 += now;
            }
        }
        
        String step3 = "";
        for (int i = 0; i < step2.length(); i++) {
            if (i < step2.length() - 1 && step2.charAt(i) == '.' && step2.charAt(i + 1) == '.') {
                continue;
            } else {
                step3 += step2.charAt(i);
            }
        }
        
        // 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String step4 = step3;
        if (step4.length() > 0 && step4.charAt(0) == '.') {
            step4 = step4.substring(1);
        }
        if (step4.length() > 0 && step4.charAt(step4.length() - 1) == '.') {
            step4 = step4.substring(0, step4.length() - 1);
        }
        
        String step5 = step4;
        if (step5.equals("")) {
            step5 = "a";
        }
        

        String step6 = step5;
        if (step6.length() >= 16) {
            step6 = step6.substring(0, 15);
        }
        if (step6.length() > 0 && step6.charAt(step6.length() - 1) == '.') {
            step6 = step6.substring(0, step6.length() - 1);
        }
        

        String step7 = step6;
        while (step7.length() <= 2) {
            step7 += step7.charAt(step7.length() - 1);
        }
        
        return step7;
    }
}
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int videolen = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int now = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int opStart = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int opEnd = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        
        if (opStart <= now && now <= opEnd) now = opEnd;
        
        for (int i = 0; i < commands.length; i++) {
            
            if (commands[i].charAt(0) == 'n') now += 10;
            else now -= 10;
            
            if (now < 0) now = 0;
            else if (videolen < now) now = videolen;
            
            
            if (opStart <= now && now <= opEnd) now = opEnd;
        
        }
        
        if (now / 60 < 10) answer += 0;
        answer += now / 60;
        answer += ":";
        if (now % 60 < 10) answer += 0;
        answer += now % 60;
        
        return answer;
    }
}
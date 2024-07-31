class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;

        // m의 "#" 처리
        m = m.replace("C#", "H").replace("D#", "I").replace("F#", "J").replace("G#", "K").replace("A#", "L");

        for (String info : musicinfos) {
            String[] now = info.split(",");
            int start = Integer.parseInt(now[0].split(":")[0]) * 60 + Integer.parseInt(now[0].split(":")[1]);
            int end = Integer.parseInt(now[1].split(":")[0]) * 60 + Integer.parseInt(now[1].split(":")[1]);
            int time = (end >= start) ? (end - start) : (end + 24 * 60 - start);

            String title = now[2];
            String score = now[3].replace("C#", "H").replace("D#", "I").replace("F#", "J").replace("G#", "K").replace("A#", "L");
            String nowMusic = score.repeat(time / score.length()) + score.substring(0, time % score.length());

            if (nowMusic.contains(m)) {
                if (time > maxTime) {
                    maxTime = time;
                    answer = title;
                }
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1) return 1;
        for (int i = 1; i <= s.length() / 2; i++) {
            String[] arr = dividedString(s, i);
            int len = check(arr);
            if (answer > len) answer = len;
        }
        System.out.println(answer);
        return answer;
    }

    String[] dividedString(String s, int n) {
        int len = s.length() / n;
        if (s.length() % n != 0) len = len + 1;

        String[] result = new String[len];

        for (int i = 0; i < result.length - 1; i++) {
            result[i] = s.substring(n * i, n * (i + 1));
        }
        result[len - 1] = s.substring(n * (len - 1), s.length());

        return result;
    }

    int check(String[] s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s[0]);
        int cnt = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i].equals(s[i - 1])) {
                cnt++;
                if (i == s.length - 1) sb.append(cnt);
            }
            else {
                if (cnt != 1) {
                    sb.append(cnt);
                    cnt = 1;
                }
                sb.append(s[i]);
            }

        }
        return sb.length();
    }
}
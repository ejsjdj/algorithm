class Solution {
    public int solution(int[] sticker) {
        int length = sticker.length;
        
        if (length == 1) return sticker[0];
        if (length == 2) return Math.max(sticker[0], sticker[1]);
        
        // 첫 번째 스티커를 선택한 경우
        int[] dp1 = new int[length];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        
        for (int i = 2; i < length - 1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
        
        // 첫 번째 스티커를 선택하지 않은 경우
        int[] dp2 = new int[length];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        
        return Math.max(dp1[length - 2], dp2[length - 1]);
    }
}
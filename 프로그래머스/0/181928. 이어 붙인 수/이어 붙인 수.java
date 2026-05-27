class Solution {
    public int solution(int[] num_list) {
        int odd_num = 0;
        int pair_num = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 1) {
                odd_num = odd_num * 10 + num_list[i];
            } else {
                pair_num = pair_num * 10 + num_list[i];
            }
        }
        
        return odd_num + pair_num;
    }
}
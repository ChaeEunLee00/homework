import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;

        if(N == 1) return sticker[0];
        else if(N == 2) return Math.max(sticker[0], sticker[1]);

        //0 ~ N-1
        int[] dp = new int[N-1];
        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0],sticker[1]);
        for(int i = 2; i < N-1; i++){
            dp[i] = Math.max(dp[i-1], sticker[i] + dp[i-2]);
        }

        //1 ~ N
        int[] dp2 = new int[N-1];
        dp2[0] = sticker[1];
        dp2[1] = Math.max(sticker[1],sticker[2]);
        for(int i = 2; i < N-1; i++){
            dp2[i] = Math.max(dp2[i-1], sticker[i+1] + dp2[i-2]);
        }

        return Math.max(dp[N-2], dp2[N-2]);
    }
}
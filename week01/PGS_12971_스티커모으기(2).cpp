#include <bits/stdc++.h>
using namespace std;

int dp[100001];

int solution(vector<int> sticker)
{
    int answer = 0;
    
    for(auto e : sticker){
        answer = max(answer, e);
    }
    
    int n = sticker.size();
    
    dp[0] = sticker[0];
    dp[1] = 0;
    dp[2] = sticker[0] + sticker[2];
    for(int i=3; i<n-1; i++){
        dp[i] = max(dp[i-2], dp[i-3]) + sticker[i];
        answer = max(answer, dp[i]);
    }
    
    fill(dp, dp+n, 0);
    dp[n-1] = sticker[n-1];
    dp[n-2] = 0;
    dp[n-3] = sticker[n-1] + sticker[n-3];
    for(int i=n-2; i>0; i--){
        dp[i] = max(dp[i+2], dp[i+3]) + sticker[i];
        answer = max(answer, dp[i]);
    }
    
    fill(dp, dp+n, 0);
    dp[1] = sticker[1];
    dp[2] = 0;
    for(int i=3; i<n-1; i++){
        dp[i] = max(dp[i-2], dp[i-3]) + sticker[i];
        answer = max(answer, dp[i]);
    }

    return answer;
}
#include <bits/stdc++.h>
using namespace std;

int n;
int cost[1001][3]; // 빨 초 파
int dp[1001][3]; // 빨 초 파
int main(){

    cin >> n;

    for(int i=1; i<=n; i++){
        cin >> cost[i][0] >>  cost[i][1] >>  cost[i][2];
    }

    dp[1][0] = cost[1][0];
    dp[1][1] = cost[1][1];
    dp[1][2] = cost[1][2];

    for(int i=2; i<=n; i++){
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
    }

    int mn = INT_MAX;

    for(int j=0; j<3; j++){
        mn = min(dp[n][j], mn);
    }

    cout << mn;


}
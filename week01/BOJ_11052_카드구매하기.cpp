#include <bits/stdc++.h>
using namespace std;

int n;
int cost[1001];
int dp[1001];

int main(){

    cin >> n;

    for(int i=1; i<=n; i++){
        cin >> cost[i];
    }

    dp[1] = cost[1];

    for(int i=2; i<=n; i++){
        dp[i] = max(dp[i], cost[i]);
        int mid = i/2;
        for(int j=1; j<=mid; j++){
            dp[i] = max(dp[i], dp[j]+dp[i-j]);
        }
    }

    cout << dp[n];

    
}
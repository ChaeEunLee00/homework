#include <bits/stdc++.h>
using namespace std;

#define pii pair<int,int>
#define X first
#define Y second
int n;
int dp[1500001]; // dp[i] :  i번째 날이 종료될 때 최대 금액
vector<pii> v[1500001]; // [끝나는날짜] = {값, 시작날짜}

int main(){

    cin >> n;
    for(int i=1; i<=n; i++){
        int day, cost;
        cin >> day >> cost;

        if(i+day-1 <= n) dp[i+day-1] = max(dp[i-1]+cost, dp[i+day-1]);
        dp[i] = max(dp[i-1], dp[i]);
        
    }

    cout << dp[n];


    // 또 다른 풀이

    // cin >> n;
    // for(int i=1; i<=n; i++){
    //     int day, cost;
    //     cin >> day >> cost;
    //     if(i + day - 1 > n) continue;
    //     v[i + day - 1].push_back({cost, i});
    // }


    // for(int i=1; i<=n; i++){
    //     dp[i] = max(dp[i-1], dp[i]);
    //     for(auto e : v[i]){
    //         int c = e.X; // 금액
    //         int st = e.Y; // 시작 날짜
    //         dp[i] = max(dp[st-1]+c, dp[i]);
    //     }
    // }

    // cout << dp[n];

}
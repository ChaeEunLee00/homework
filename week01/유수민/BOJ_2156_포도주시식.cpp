#include <bits/stdc++.h>
using namespace std;

int grape[10001];
int n;

int dp[10001];

int main(){

    cin >> n;

    for(int i=1; i<=n; i++){
        cin >> grape[i];
    }


    dp[1] = grape[1];
    dp[2] = grape[1]+grape[2];

    for(int i=3; i<=n; i++){
        dp[i] = max(dp[i-1], max(dp[i-3]+grape[i-1]+grape[i], dp[i-2]+grape[i]));
    }


    cout << dp[n];

}
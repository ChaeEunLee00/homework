#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int n, k;
pair<int, int> bag[101];

int dp[101][100001]; // dp[i][k] i번째 물건까지 확인했을 때, 무게가 k인 경우의 최대 가치

int main(){

    cin >> n >> k;
    for(int i=1; i<=n; i++){
        int w, k;
        cin >> w >> k;
        bag[i] = {w, k};
    }

    for(int i=1; i<=n; i++){ // 물건

        for(int j=1; j<=k; j++){ // 무게

            if(j >= bag[i].X){
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-bag[i].X]+bag[i].Y);
            }
            else dp[i][j] = dp[i-1][j];
        }
    }

    cout << dp[n][k];


}
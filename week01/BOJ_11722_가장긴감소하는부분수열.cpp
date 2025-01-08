#include <bits/stdc++.h>
using namespace std;

int dp[1001];
int arr[1001];

int main(){
    int n;
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    fill(dp, dp+n+1, 1);

    for(int i=1; i<n; i++){
        for(int j=i-1; j>=0; j--){
            if(arr[j] > arr[i]){
                dp[i] = max(dp[i], dp[j]+1);
            }
            //dp[i] = max(dp[i], dp[j]);
        }
    }
    
    int mx = 0;
    for(int i=0; i<n; i++){
        mx = max(dp[i], mx);
    }

    cout << mx;
}
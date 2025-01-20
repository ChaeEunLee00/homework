#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[501][501];
int ans = 0;

void rect1(){

    // 가로형
    int sum = 0;
    for(int i=1; i<=n; i++){
        for(int t=1; t<=m-3; t++){
            sum = 0;
            for(int j=t; j<t+4; j++){
                sum += board[i][j];
            }
            ans = max(ans, sum);
        }
        
    }
    
    // 세로형
    sum = 0;
    for(int j=1; j<=m; j++){
        for(int t=1; t<=n-3; t++){
            sum = 0;
            for(int i=t; i<t+4; i++){
                sum += board[i][j];
            }
            ans = max(ans, sum);
        }
    }
}

void rect2(){
    for(int i=1; i<n; i++){
        for(int j=1; j<m; j++){
            int sum = 0;
            sum += board[i][j];
            sum += board[i+1][j];
            sum += board[i][j+1];
            sum += board[i+1][j+1];
            ans = max(ans, sum);
        }
    }
}

void rect4(){
    // 가로형
    for(int i=1; i<=n; i++){
        for(int j=1; j<m; j++){
            int sum = 0;
            sum += board[i][j];
            sum += board[i][j+1];
            if(i-1 >= 1 && i+1 <=n){
                ans = max(ans, sum+board[i-1][j]+board[i+1][j+1]);
                ans = max(ans, sum+board[i-1][j+1]+board[i+1][j]);
            }
        }
    }
    // 세로형
    for(int i=1; i<n; i++){
        for(int j=1; j<=m; j++){
            int sum = 0;
            sum += board[i][j];
            sum += board[i+1][j];
            if(j-1>=1 && j+1 <= m){
                ans = max(ans, sum+board[i][j-1]+board[i+1][j+1]);
                ans = max(ans, sum+board[i][j+1]+board[i+1][j-1]);
            }
        }
    }
    
}

void rect35(){
    // 가로형
    for(int i=1; i<=n; i++){
        for(int t=1; t<=m-2; t++){
            int sum = 0;
            sum += board[i][t];
            sum += board[i][t+1];
            sum += board[i][t+2];
            if(i-1 >= 1){
                ans = max(ans, sum+board[i-1][t]);
                ans = max(ans, sum+board[i-1][t+1]);
                ans = max(ans, sum+board[i-1][t+2]);
            }
            if(i+1 <= n){
                ans = max(ans, sum+board[i+1][t]);
                ans = max(ans, sum+board[i+1][t+1]);
                ans = max(ans, sum+board[i+1][t+2]);
            }
            
        }
    }
    // 세로형
    for(int j=1; j<=m; j++){
        for(int t=1; t<=n-2; t++){
            int sum = 0;
            sum += board[t][j];
            sum += board[t+1][j];
            sum += board[t+2][j];
            if(j-1 >= 1){
                ans = max(ans, sum+board[t][j-1]);
                ans = max(ans, sum+board[t+1][j-1]);
                ans = max(ans, sum+board[t+2][j-1]);
            }
            if(j+1 <= m){
                ans = max(ans, sum+board[t][j+1]);
                ans = max(ans, sum+board[t+1][j+1]);
                ans = max(ans, sum+board[t+2][j+1]);
            }
            
        }
    }
}

int main(){
    cin >> n >> m;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            cin >> board[i][j];
        }
    }
    rect1();
    rect2();
    rect4();
    rect35();

    cout << ans;
}
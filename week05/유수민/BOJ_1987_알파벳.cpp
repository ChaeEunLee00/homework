#include <bits/stdc++.h>
using namespace std;

char board[21][21];
int r, c;
bool isVis[30];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int answer = 0;

void dfs(int x, int y, bool vis[], int cnt){

    answer = max(answer, cnt);

    for(int t=0; t<4; t++){
        int nx = x + dx[t];
        int ny = y + dy[t];
        if(nx < 1 || nx > r || ny < 1 || ny > c) continue;
        int ch = board[nx][ny]-'A';

        if(vis[ch]) continue;
        vis[ch] = true;
        dfs(nx, ny, vis, cnt+1);
        vis[ch] = false;
    }
    
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> r >> c;
    for(int i=1; i<=r; i++){
        string str;
        cin >> str;
        for(int j=1; j<=c; j++){
            board[i][j] = str[j-1];
        }
    }

    isVis[board[1][1]-'A'] = true;
    dfs(1, 1, isVis, 1);

    cout << answer;

    return 0;
}
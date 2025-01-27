#include <bits/stdc++.h>
using namespace std;
#define pii pair<int,int>
#define X first
#define Y second

int n, m;
int r, c, d;
int board[51][51];
int ans;

int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1}; // 북 동 남 서

bool chk(int x, int y){
    bool b = false;
    for(int t=0; t<4; t++){
        int nx = x + dx[t];
        int ny = y + dy[t];
        if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
        if(board[nx][ny] == 0){
            b = true;
            break;
        }
    }
    return b;
}

int main(){
    cin >> n >> m;
    cin >> r >> c >> d;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            cin >> board[i][j];
        }
    }
    r++;
    c++;

    while(1){
        if(board[r][c] == 0){
            board[r][c] = 2;
            ans++;
        }
        else if(chk(r, c) == false){
            int dir = (d+2) % 4;
            int nx = r + dx[dir];
            int ny = c + dy[dir];
            if(nx < 1 || nx > n || ny < 1 || ny > m) break;
            else if(board[nx][ny] == 1) break;
            else{
                r = nx;
                c = ny;
            }
        }
        else if(chk(r, c) == true){
            d = (d+3) % 4;
            int nx = r + dx[d];
            int ny = c + dy[d];
            if(nx > 0 && nx <= n && ny > 0 && ny <= m && board[nx][ny] == 0){
                r = nx;
                c = ny;
            }
        }
    }

    cout << ans;
}
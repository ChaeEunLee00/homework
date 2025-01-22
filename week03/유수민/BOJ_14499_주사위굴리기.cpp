#include <bits/stdc++.h>
using namespace std;

int n, m;
int x, y;
int k;
int board[21][21];

int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int dice[7] = {-1, 0, 0, 0, 0, 0, 0};
int temp[7];

vector<int> ans;

void change(int nx, int ny, int dir){
    int tt = 0;
    if(dir == 0) tt = 1;
    else if(dir == 1) tt = 3;
    else if(dir == 2) tt = 4;
    else tt = 5;

    if(board[nx][ny] == 0) board[nx][ny] = temp[tt];
    else {
        temp[tt] = board[nx][ny];
        board[nx][ny] = 0;
    }
}

void calc(int dir){
    int nx = x + dx[dir];
    int ny = y + dy[dir];
    if(nx < 1 || nx > n || ny < 1 || ny > m) return;
    

    for(int t=1; t<7; t++){
        temp[t] = dice[t];
    }
    
    int tp = 0;
    switch(dir){
        case 0:
            change(nx, ny, dir);
            dice[6] = temp[1];
            dice[1] = temp[2];
            dice[2] = temp[3];
            dice[3] = temp[6];
            tp = dice[2];
            break;
        case 1:
            change(nx, ny, dir);
            dice[2] = temp[1];
            dice[3] = temp[2];
            dice[6] = temp[3];
            dice[1] = temp[6];
            tp = dice[2];
            break;
        case 2:
            change(nx, ny, dir);
            dice[4] = temp[2];
            dice[6] = temp[4];
            dice[2] = temp[5];
            dice[5] = temp[6];
            tp = dice[2];
            break;
        case 3:
            change(nx, ny, dir);
            dice[5] = temp[2];
            dice[2] = temp[4];
            dice[6] = temp[5];
            dice[4] = temp[6];
            tp = dice[2];
            break;
    }
    ans.push_back(tp);

    x = nx;
    y = ny;
}

int main(){
    cin >> n >> m >> x >> y >> k;
    x++, y++;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            cin >> board[i][j];
        }
    }

    int dir; // 1 2 3 4 동서북남
    for(int t=0; t<k; t++){
        cin >> dir;
        dir--;

        calc(dir);
    }

    for(auto a : ans) cout << a << "\n";


}
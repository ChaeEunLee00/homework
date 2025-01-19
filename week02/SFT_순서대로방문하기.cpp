#include<bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

int board[5][5];
int n, m;
vector<pii> pos;

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int ans;
bool vis[5][5];

void func(int num, int x, int y){

    int temp = num;
    if(x == pos[num].X && y == pos[num].Y){
        if(num == m-1){
            ans++;
            return;
        }
        temp++;
    }

    for(int i=0; i<4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
        if(vis[nx][ny] == true || board[nx][ny] == 1) continue;
        vis[nx][ny] = true;
        func(temp, nx, ny);
        vis[nx][ny] = false;
    }
    
    
}

int main(int argc, char** argv)
{
    cin >> n >> m;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cin >> board[i][j];
        }
    }
    for(int i=0; i<m; i++){
        int x, y;
        cin >> x >> y;
        pos.push_back({x, y});
    }

    vis[pos[0].X][pos[0].Y] = true;
    func(1, pos[0].X, pos[0].Y);

    cout << ans;

   return 0;
}
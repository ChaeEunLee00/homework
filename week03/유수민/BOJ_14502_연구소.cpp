#include <bits/stdc++.h>
using namespace std;

#define pii pair<int,int>
#define X first
#define Y second

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int n, m;
int board[10][10];
int newboard[10][10];
bool vis[10][10];
vector<pii> blank;
vector<pii> virus;
int ans = INT_MIN;

void calc(vector<pii> walls){
    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            newboard[i][j] = board[i][j];
        }
    }
    for(auto e : walls) newboard[e.X][e.Y] = 1;

    queue<pii> q;
    for(auto e : virus) {
        q.push({e.X, e.Y});
        vis[e.X][e.Y] = true;
    }
    while(!q.empty()){
        auto cur = q.front();
        q.pop();

        for(int t=0; t<4; t++){
            int nx = cur.X + dx[t];
            int ny = cur.Y + dy[t];
            if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if(vis[nx][ny] || newboard[nx][ny] == 1) continue;
            newboard[nx][ny] = 2;
            vis[nx][ny] = true;
            q.push({nx, ny});
        }
    }

    int cnt = 0;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            if(newboard[i][j] == 0) cnt++;
        }
    }

    ans = max(ans, cnt);

    for(int i=0; i<10; i++) fill(vis[i], vis[i]+10, false);
}


int main(){
    cin >> n >> m;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            cin >> board[i][j];
            if(board[i][j] == 0) blank.push_back({i, j});
            else if(board[i][j] == 2) virus.push_back({i, j});
        }
    }

    vector<int> brute(blank.size()-3, 0);
    for(int i=0; i<3; i++) brute.push_back(1);

    do{
        vector<pii> temp;
        for(int i=0; i<brute.size(); i++){
            if(brute[i] == 1) temp.push_back(blank[i]);
        }
        calc(temp);
    }while(next_permutation(brute.begin(), brute.end()));

    cout << ans;
}
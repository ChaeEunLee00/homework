#include <bits/stdc++.h>
using namespace std;

#define pii pair<int,int>
#define X first
#define Y second

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int r, c;
char board[1001][1001];
pii st;
vector<pii> fire;
int dist[1001][1001];
bool vis[1001][1001];
int answer = INT_MAX;

void calcDist(){
    for(int i=1; i<=r; i++) fill(dist[i], dist[i]+c+1, -1);
    queue<pair<pii, int>> q;
    for(auto f : fire){
        q.push({f, 0});
        dist[f.X][f.Y] = 0;
    }
    

    while(!q.empty()){
        auto cur = q.front();
        q.pop();

        for(int t=0; t<4; t++){
            int nx = cur.X.X + dx[t];
            int ny = cur.X.Y + dy[t];
            if(nx < 1 || nx > r || ny < 1 || ny > c) continue;
            if(board[nx][ny] == '#') continue;
            if(dist[nx][ny] != -1 && dist[nx][ny] <= cur.Y + 1) continue;

            dist[nx][ny] = cur.Y + 1;
            q.push({{nx, ny}, cur.Y+1});
        }
    }
}

void start(){
    queue<pair<pii, int>> q;
    q.push({st, 0});
    vis[st.X][st.Y] = true;

    while(!q.empty()){
        auto cur = q.front();
        q.pop();
        if(cur.X.X == 1 || cur.X.X == r || cur.X.Y == 1 || cur.X.Y == c) {
            answer = min(answer, cur.Y+1);
            continue;
        }

        for(int t=0; t<4; t++){
            int nx = cur.X.X + dx[t];
            int ny = cur.X.Y + dy[t];
            if(nx < 1 || nx > r || ny < 1 || ny > c) continue;
            if(vis[nx][ny] || board[nx][ny] == '#') continue;

            if(dist[nx][ny] != -1 && dist[nx][ny] <= cur.Y+1) continue;

            vis[nx][ny] = true;
            q.push({{nx, ny}, cur.Y+1});
        }
    }
}


int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> r >> c;
    for(int i=1; i<=r; i++){
        for(int j=1; j<=c; j++){
            cin >> board[i][j];
            if(board[i][j] == 'J') st = {i, j};
            else if(board[i][j] == 'F') fire.push_back({i, j});
        }
    }

    calcDist();
    // for(int i=1; i<=r; i++){
    //     for(int j=1; j<=c; j++){
    //         cout << dist[i][j];
    //     }
    //     cout << "\n";
    // }
    start();

    if(answer == INT_MAX) cout << "IMPOSSIBLE";
    else cout << answer;
}
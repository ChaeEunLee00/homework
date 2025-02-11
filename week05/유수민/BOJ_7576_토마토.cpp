#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

int n, m;
int box[1001][1001];
int dist[1001][1001];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int tomato;
int answer = -1;
vector<pii> st;

int main(){
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(0);

    cin >> m >> n;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            cin >> box[i][j];
            if(box[i][j] == 1) st.push_back({i, j});
            else if(box[i][j] == 0) tomato++;
        }
    }

    for(int i=1; i<=n; i++) fill(dist[i], dist[i]+m+1, INT_MAX);

    queue<pair<pii, int>> q;
    for(auto s : st){
        q.push({s, 0});
        dist[s.X][s.Y] = 0;
    }
    int count = 0;
    while(!q.empty()){
        auto cur = q.front();
        q.pop();

        for(int t=0; t<4; t++){
            int nx = cur.X.X + dx[t];
            int ny = cur.X.Y + dy[t];

            if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if(box[nx][ny] == -1) continue;
            if(dist[nx][ny] <= cur.Y+1) continue;

            if(dist[nx][ny] == INT_MAX) count++;
            dist[nx][ny] = cur.Y + 1;
            q.push({{nx, ny}, cur.Y+1});

        }
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            if(dist[i][j] != INT_MAX){
                answer = max(answer, dist[i][j]);
            }
        }
    }

    if(tomato != count) answer = -1;
    cout << answer;
}
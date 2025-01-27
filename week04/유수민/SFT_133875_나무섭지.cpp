#include <bits/stdc++.h>
#define X first
#define Y second
#define pii pair<int, int>

using namespace std;

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int n, m;
char board[1001][1001];
int dist[1001][1001];
bool vis[1001][1001];

vector<pii> goast;
pii namwoo, door;

int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> board[i][j];
            if (board[i][j] == 'G') goast.push_back({i, j});
            else if (board[i][j] == 'N') namwoo = {i, j};
            else if (board[i][j] == 'D') door = {i, j};
        }
    }

    for (int i = 1; i <= n; i++) fill(dist[i] + 1, dist[i] + m + 1, INT_MAX);

    queue<pii> q;
    for (pii g : goast) {
        q.push(g);
        dist[g.X][g.Y] = 0;
    }

    while (!q.empty()) {
        pii cur = q.front();
        q.pop();
        for (int t = 0; t < 4; t++) {
            int nx = cur.X + dx[t];
            int ny = cur.Y + dy[t];
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if (dist[nx][ny] <= dist[cur.X][cur.Y] + 1) continue;
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
            q.push({nx, ny});
        }
    }


    string ans = "No";
    for (int i = 1; i <= n; i++) fill(vis[i], vis[i] + m + 1, false);
    queue<pair<int, pii>> nq;
    nq.push({0, namwoo});
    vis[namwoo.X][namwoo.Y] = true;

    while (!nq.empty()) {
        auto cur = nq.front();
        nq.pop();

        if (cur.Y.X == door.X && cur.Y.Y == door.Y) {
            if (cur.X <= dist[door.X][door.Y]) {
                ans = "Yes";
                break;
            }
        }

        for (int t = 0; t < 4; t++) {
            int nx = cur.Y.X + dx[t];
            int ny = cur.Y.Y + dy[t];
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if (vis[nx][ny] || board[nx][ny] == '#' || cur.X + 1 >= dist[nx][ny]) continue;

            vis[nx][ny] = true;
            nq.push({cur.X + 1, {nx, ny}});
        }
    }

    cout << ans;
    return 0;
}

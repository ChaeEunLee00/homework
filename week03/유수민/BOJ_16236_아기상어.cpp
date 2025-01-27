#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>
#define ppi pair<int, pii>

int n;
int board[21][21];
bool vis[21][21];
int ate = 0;

int sz = 2;
int x;
int y;
int answer = 0; // 몇 초 동안 엄마 상어에게 

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int main(){

    cin >> n;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cin >> board[i][j];
            if(board[i][j] == 9){
                x = i;
                y = j;
                board[i][j] = 0;
            }
        }
    }

    while(1){

        for(int t=1; t<=n; t++) fill(vis[t], vis[t]+n+1, false);
        priority_queue<ppi, vector<ppi>, greater<ppi>> pq;
        pq.push({0, {x, y}}); // {이동시간, x, y}
        vis[x][y] = true;
        bool isFish = false;

        while(!pq.empty()){
            auto cur = pq.top();
            pq.pop();
            
            // 우선순위 고려하여 먹을 수 있는 물고기 발견
            if(board[cur.Y.X][cur.Y.Y] < sz && board[cur.Y.X][cur.Y.Y] != 0){
                
                board[cur.Y.X][cur.Y.Y] = 0;
                ate++;
                if(ate == sz){
                    sz++;
                    ate = 0;
                }
                answer += cur.X;
                x = cur.Y.X, y = cur.Y.Y;
                isFish = true;
                break;
            }

            for(int t=0; t<4; t++){
                int nx = cur.Y.X + dx[t];
                int ny = cur.Y.Y + dy[t];
                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if(board[nx][ny] > sz) continue; // 큰 물고기 지나갈 수 없음
                if(vis[nx][ny]) continue;

                
                pq.push({cur.X+1, {nx, ny}});
                vis[nx][ny] = true;
            }
        }

        if(!isFish) break;

    }

    cout << answer;
}
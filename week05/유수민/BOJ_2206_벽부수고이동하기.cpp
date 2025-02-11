#include <bits/stdc++.h>
using namespace std;

#define pii pair<int,int>
#define pib pair<int,bool>
#define X first
#define Y second

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int n, m;
char board[1001][1001];
int answer = INT_MAX;
int vis[1001][1001]; // 0: 방문하지 않음, 1: 부수지 않고 방문, 2:부수고 방문

void bfs(){
    
    queue<pair<pii, pib>> q; // {x, y}, {경로칸수, 부수기여부}
    q.push({{1, 1}, {1, false}});
    vis[1][1] = 1;

    while(!q.empty()){
        
        
        auto cur = q.front();
        q.pop();
        // cout << cur.X.X << ", " << cur.X.Y << " | " <<  cur.Y.X << ", " << cur.Y.Y << "\n";

        if(cur.X.X == n && cur.X.Y == m){
            answer = min(answer, cur.Y.X);
            continue;
        }

        for(int t=0; t<4; t++){
            int nx = cur.X.X + dx[t];
            int ny = cur.X.Y + dy[t];

            if(nx == n && ny == m){
                q.push({{nx, ny}, {cur.Y.X+1, cur.Y.Y}});
                continue;
            }

            if(nx < 1 || nx > n || ny < 1 || ny > m) continue;

            // 더 이상 부술 수 없음
            if(board[nx][ny] == '1' && cur.Y.Y == true) continue;


            if(board[nx][ny] == '1'){
                if(vis[nx][ny] == 0){
                    vis[nx][ny] = 2;
                    q.push({{nx, ny}, {cur.Y.X+1, true}});
                } 
            }
            else{
                if(cur.Y.Y == false){ // 아직 안 부숨
                    if(vis[nx][ny] == 0){
                        vis[nx][ny] = 1;
                        q.push({{nx, ny}, {cur.Y.X+1, false}});
                    }
                    else if(vis[nx][ny] == 2){
                        vis[nx][ny] = 1;
                        q.push({{nx, ny}, {cur.Y.X+1, false}});
                    }
                }
                else{ // 부숨
                    if(vis[nx][ny] == 0){
                        vis[nx][ny] = 2;
                        q.push({{nx, ny}, {cur.Y.X+1, true}});
                    }
                }
            }
        }
    }
    
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> m;
    for(int i=1; i<=n; i++){
        string str;
        cin >> str;
        for(int j=1; j<=m; j++){
            board[i][j] = str[j-1];
        }
    }

    bfs();

    cout << (answer == INT_MAX ? -1 : answer);

    return 0;
}
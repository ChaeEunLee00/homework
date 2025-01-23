#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

char board[12][6];
bool vis[12][6];

int answer;

int main(){

    string str;
    for(int i=0; i<12; i++){
        cin >> str;
        for(int j=0; j<6; j++){
            board[i][j] = str[j];
        }
    }

    while(1){
        
        bool b = false;
        for(int k=0; k<12; k++) fill(vis[k], vis[k]+6, false);
        
        vector<pii> del;
        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                if(board[i][j] == '.' || vis[i][j]) continue;

                char ch = board[i][j];
                queue<pii> q;
                vector<pii> temp;
                
                q.push({i, j});
                vis[i][j] = true;
                int cnt = 0;

                while(!q.empty()){
                    auto cur = q.front();
                    temp.push_back({cur.X, cur.Y});
                    cnt++;
                    q.pop();

                    for(int t=0; t<4; t++){
                        int nx = cur.X + dx[t];
                        int ny = cur.Y + dy[t];
                        if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                        if(vis[nx][ny] || board[nx][ny] != ch) continue;
                        q.push({nx, ny});
                        vis[nx][ny] = true;
                    }                
                }

                if(cnt >= 4){
                    b = true;
                    del.insert(del.end(), temp.begin(), temp.end());
                }
            }
        }
        
        if(b){
            answer++;
            for(auto p : del){
                board[p.X][p.Y] = '.';
            }
            
            for(int y=0; y<6; y++){
                stack<char> st;
                for(int x=0; x<12; x++){
                    if(board[x][y] != '.') st.push(board[x][y]);
                }
                for(int x=11; x>=0; x--){
                    if(!st.empty()){
                        board[x][y] = st.top();
                        st.pop();
                    } else {
                        board[x][y] = '.';
                    }
                }
            }
        } else {
            break;
        }
    }

    cout << answer;
}
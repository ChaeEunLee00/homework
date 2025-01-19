#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

char board[6][6];
int vis[6][6];
int ans = 0;

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

void calc(vector<int> nums){

    for(int i=0; i<6; i++) fill(vis[i], vis[i]+6, 0);
    int x, y;
    for(int n : nums){
        if(n % 5 == 0){
            x = n/5;
            y = 5;
        }
        else{
            x = n / 5 + 1;
            y = n % 5;
        }
        
        vis[x][y] = 2;
    }
    
    queue<pii> q;
    q.push({x, y});
    int dasom = 0;
    int doyon = 0;
    if(board[x][y] == 'S') dasom++;
    else doyon++;
    vis[x][y] = 1;

    while(!q.empty()){
        auto cur = q.front();
        q.pop();

        for(int t=0; t<4; t++){
            int nx = cur.X + dx[t];
            int ny = cur.Y + dy[t];
            if(nx < 1 || nx > 5 || ny < 1 || ny > 5) continue;
            
            if(vis[nx][ny] == 2){
                if(board[nx][ny] == 'S') dasom++;
                else doyon++;
                vis[nx][ny] = 1;
                q.push({nx, ny});
            }
        }
    }

    if((dasom + doyon) == 7 && dasom > doyon) {
        ans++;
    }

}

void recur(int num, vector<int>& nums){

    if(nums.size() == 7){
        calc(nums);
        return;
    }

    if(num > 25) return;

    recur(num+1, nums);

    nums.push_back(num);
    recur(num+1, nums);
    nums.pop_back();
}

int main(){

    for(int i=1; i<=5; i++){
        string str;
        cin >> str;
        for(int j=1; j<=str.size(); j++){
            board[i][j] = str[j-1];
        }
    }

    vector<int> temp;
    recur(1, temp);

    cout << ans;
}
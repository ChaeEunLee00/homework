#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int board[401][401];
bool isLike[401][401];
int n;
int student;
int answer;

// {좋아하는학생수, 비어있는 칸, r, c}
bool cmp(pair<pii, pii> a, pair<pii, pii> b){

    if(a.X.X == b.X.X){
        if(a.X.Y == b.X.Y){
            if(a.Y.X == b.Y.X){
                return a.Y.Y < b.Y.Y;
            }
            return a.Y.X < b.Y.X;
        }
        return a.X.Y > b.X.Y;
    }
    return a.X.X > b.X.X;
}

void play(int num){

    vector<pair<pii, pii>> wh;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            if(board[i][j] != 0) continue;

            int likes = 0;
            int blanks = 0;
            for(int t=0; t<4; t++){
                int nx = i + dx[t];
                int ny = j + dy[t];
                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if(board[nx][ny] == 0) blanks++;
                else if(isLike[num][board[nx][ny]]) likes++;
            }
            wh.push_back({{likes, blanks}, {i, j}});
        }
    }
    sort(wh.begin(), wh.end(), cmp);

    int x = wh[0].Y.X;
    int y = wh[0].Y.Y;
    board[x][y] = num;

}


int main(){
    cin >> n;

    vector<int> rounds;
    for(int i=0; i<n*n; i++){
        cin >> student;
        int tt;
        for(int t=0; t<4; t++){
            cin >> tt;
            isLike[student][tt] = true;
        }
        rounds.push_back(student);
    }

    for(auto r : rounds){
        play(r);
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            int cnt = 0;
            for(int t=0; t<4; t++){
                int nx = i + dx[t];
                int ny = j + dy[t];
                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if(isLike[board[i][j]][board[nx][ny]]) cnt++;
            }
            if(cnt == 1) answer += 1;
            else if(cnt == 2) answer += 10;
            else if(cnt == 3) answer += 100;
            else if(cnt == 4) answer += 1000;
        }
    }

    cout << answer;
}
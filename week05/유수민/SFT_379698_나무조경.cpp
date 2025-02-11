#include<bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

int dx[2] = {0, 1};
int dy[2] = {1, 0};

int n;
int board[5][5];
bool isUsed[5][5];
int answer = 0;
vector<pair<pii, pii>> pairs;

void makePairs(){
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){

            for(int t=0; t<2; t++){
                int nx = i + dx[t];
                int ny = j + dy[t];

                if(nx > n || ny > n) continue;
                pairs.push_back({{i, j}, {nx, ny}});
            }
        }
    }
}

void func(vector<pair<pii,pii>> v){

    for(int i=1; i<=n; i++) fill(isUsed[i], isUsed[i]+n+1, false);

    int tot = 0;
    for(auto e : v){
        if(!isUsed[e.X.X][e.X.Y] && !isUsed[e.Y.X][e.Y.Y]){
            tot += board[e.X.X][e.X.Y];
            tot += board[e.Y.X][e.Y.Y];
            isUsed[e.X.X][e.X.Y] = true;
            isUsed[e.Y.X][e.Y.Y] = true;
        }
    }
    
    answer = max(answer, tot);
}

int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> n;
    int tot = 0;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cin >> board[i][j];
            tot += board[i][j];
        }
    }

    if(n == 2){
        cout << tot;
        return 0;
    }

    makePairs();


    vector<int> brute(pairs.size()-4, 0);
    for(int t=0; t<4; t++) brute.push_back(1);

    do{
        vector<pair<pii,pii>> temp;
        for(int i=0; i<brute.size(); i++){
            if(brute[i] == 1) temp.push_back(pairs[i]);
        }
        func(temp);
    }while(next_permutation(brute.begin(), brute.end()));

    cout << answer;
    

   return 0;
}
#include<bits/stdc++.h>
using namespace std;

#define pii pair<int,int>
#define X first
#define Y second

int n, m;
int board[51][14];
vector<pii> home;
vector<pii> chick;
int dist = INT_MAX;

void calc(vector<pii> ch){
    
    int sum = 0;
    for(auto h : home){
        int hx = h.X;
        int hy = h.Y;
        int num = INT_MAX;
        for(auto cur : ch){
            int x = cur.X;
            int y = cur.Y;
            num = min(num, abs(hx-x)+abs(hy-y));
        }
        sum += num;
    }
    dist = min(dist, sum);
    
}

int main(){
    
    cin >> n >> m;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cin >> board[i][j];
            if(board[i][j] == 1) home.push_back({i, j});
            else if(board[i][j] == 2) chick.push_back({i, j});
        }
    }

    vector<int> brute(chick.size()-m, 0);
    for(int i=0; i<m; i++) brute.push_back(1);

    do{
        vector<pii> temp;
        for(int t=0; t<brute.size(); t++){
            if(brute[t] == 1) temp.push_back(chick[t]);
        }
        calc(temp);
    }while(next_permutation(brute.begin(), brute.end()));

    cout << dist;

}
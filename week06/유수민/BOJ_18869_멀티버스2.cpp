#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second


int n, m;
vector<int> planet[101];
int ch[101][10001];
string ranks[101];
int answer;

void makeRank(vector<int> sz, int id){
    vector<pair<int,int>> temp;
    for(int i=0; i<sz.size(); i++) temp.push_back({sz[i], i});
    sort(temp.begin(), temp.end());

    
    int ranking = 0;
    ch[id][temp[0].Y] = ++ranking;
    for(int i=1; i<temp.size(); i++){
        int number = temp[i].X;
        int idx = temp[i].Y;

        if(number != temp[i-1].X){
            ch[id][idx] = ++ranking;
        }
        else{
            ch[id][idx] = ranking;
        }
    }

}

int main(){

    cin >> m >> n;
    

    for(int i=1; i<=m; i++){
        for(int k=0; k<n; k++){
            int sz;
            cin >> sz;
            planet[i].push_back(sz);
        }
        makeRank(planet[i], i);
    }

    for(int i=1; i<=m; i++){
        for(int j=0; j<n; j++){
            ranks[i] += ch[i][j];
        }
    }

    // 쌍 개수 구하기
    for(int i=1; i<=m; i++){
        for(int j=i+1; j<=m; j++){
            if(ranks[i] == ranks[j]) answer++;
        }
    }

    cout << answer;
}
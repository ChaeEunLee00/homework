#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

int n;
int x, y;
vector<pii> states;

bool cmp(pii a, pii b){
    
    if(a.Y == b.Y) return a.X > b.X;
    return a.Y > b.Y;
}

int main(){
    cout.tie(0);
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> x >> y;
        states.push_back({x, y});
    }

    sort(states.begin(), states.end(), cmp);

    long long answer = 0;
    int tp = 0;
    
    for(int i=0; i<n; i++){
        int st = states[i].X;
        int en = states[i].Y;

        if(i == 0){
            tp = st;
            answer += (en - st);
            continue;
        }

        if(st < tp && en < tp){
            answer += (en - st);
        }
        else if(st < tp){
            answer += (tp - st);
        }
        else continue;

        tp = st;

    }

    cout << answer;


}
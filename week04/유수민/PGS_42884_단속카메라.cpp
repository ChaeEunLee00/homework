#include <bits/stdc++.h>

using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

int n;
vector<pii> path;

bool cmp(pii a, pii b){
    if(a.Y == b.Y) return a.X > b.X;
    return a.Y > b.Y;
}

int solution(vector<vector<int>> routes) {
    int answer = 0;
    
    n = routes.size();
    for(int i=0; i<n; i++){
        int st = routes[i][0];
        int en = routes[i][1];
        path.push_back({st, en});
    }
    
    sort(path.begin(), path.end(), greater<>());
    
    int tp = path[0].X;
    answer++;
    
    for(int i=1; i<n; i++){
        int st = path[i].X;
        int en = path[i].Y;
        
        if(en < tp){
            answer++;
            tp = st;
        }
        
    }
 
    return answer;
    
    
}
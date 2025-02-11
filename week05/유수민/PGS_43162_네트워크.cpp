#include <bits/stdc++.h>
using namespace std;

int vis[205];
vector<vector<int>> connect;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    queue<int> Q;
    
    for(int i=0; i<n; i++){
        vector<int> tmp;
        for(int j=0; j<n; j++){
            if(computers[i][j] == 1) tmp.push_back(j);
        }
        connect.push_back(tmp);
    }
    
    for(int i=0; i<n; i++){
        if(vis[i] == 1) continue;
        else Q.push(i);
        while(!Q.empty()){
            int cur = Q.front();
            Q.pop();
            
            vis[cur] = 1;
            for(auto v : connect[cur]){
                if(vis[v] == 0) Q.push(v);
            }        
        }
        answer++;
    }
    return answer;
}
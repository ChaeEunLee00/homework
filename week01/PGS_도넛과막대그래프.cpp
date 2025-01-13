#include <bits/stdc++.h>
using namespace std;

int degree[1000001][2];
vector<int> graph[1000001];
bool vis[1000001];
int n;
int starter;
int donut;
int stick;
int eight;

void dfs(int node, int cntNode, int cntEdge){
    
    //cout << node << " : " << cntNode << ", " << cntEdge << "\n";
    
    if(vis[node] == true){
        if(graph[node].size() == 0){
            stick++;
            return;
        }
        else if(graph[node].size() == 1){
            donut++;
            return;
        }
        else {
            eight++;
            return;
        }

    }
    
    vis[node] = true;
    
    if(graph[node].size() == 0){
        dfs(node, cntNode, cntEdge);
    }
    else if(graph[node].size() == 1){
        if(vis[graph[node][0]] == false) dfs(graph[node][0], cntNode+1, cntEdge+1);
        else dfs(graph[node][0], cntNode, cntEdge+1);
    }
    else{
        eight++;
        return;
    }
    
    
}

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer;
    
    for(auto e : edges){
        int st = e[0];
        int en = e[1];   
        degree[st][0]++;
        degree[en][1]++;
        graph[st].push_back(en);
        n = max(n, max(st, en));
    }
    
    for(int i=1; i<=n; i++){
        if(degree[i][0] >= 2 && degree[i][1] == 0){
            starter = i;
            break;
        }
    }
    
    for(auto e : graph[starter]){
        dfs(e, 1, 0);
    }
    
    answer = {starter, donut, stick, eight};
    
    return answer;
}
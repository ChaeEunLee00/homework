#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> s;
vector<bool> visited, finished;
int cnt;

void dfs(int node) {
    visited[node] = true;
    int next = s[node];

    if (!visited[next]) { 
        dfs(next);
    } 
    else if (!finished[next]) { // 방문은 했지만 아직 DFS 종료되지 않은 경우 -> 싸이클 존재
        for (int temp = next; temp != node; temp = s[temp]) {
            cnt--; // 싸이클에 포함된 노드 수 감소
        }
        cnt--; // 자기 자신도 포함
    }

    finished[node] = true; // DFS 종료
}

int calc() {
    visited.assign(n + 1, false);
    finished.assign(n + 1, false);
    cnt = n;

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) dfs(i);
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    while (T--) {
        cin >> n;
        s.assign(n + 1, 0);

        for (int i = 1; i <= n; i++) {
            cin >> s[i];
        }

        cout << calc() << "\n";
    }

    return 0;
}

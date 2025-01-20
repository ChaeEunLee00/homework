#include <bits/stdc++.h>
using namespace std;

int n;
int ss[10];
int w[10];
bool fragile[10];

int ans = 0;

void func(int num){

    if(num == n+1){
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(fragile[i]==true) cnt++;
        }
        ans = max(ans, cnt);
        return;
    }

    int cur = num; // 들고 있는 계란 번호
    if(fragile[cur]){
        func(cur+1);
    }
    else{
        bool b = false;
        for(int i=1; i<=n; i++){
            if(i == cur || fragile[i] == true) continue;
            b = true;

            ss[cur] -= w[i];
            ss[i] -= w[cur];
            if(ss[cur] <= 0) fragile[cur] = true;
            if(ss[i] <= 0) fragile[i] = true;

            func(cur+1);

            ss[cur] += w[i];
            ss[i] += w[cur];
            fragile[cur] = false;
            fragile[i] = false;
        }
        if(b == false){
            func(n+1);
        }
    }

    
}

int main(){
    cin >> n;

    for(int i=1; i<=n; i++){
        cin >> ss[i] >> w[i];
    }

    func(1);

    cout << ans;
}
#include <bits/stdc++.h>
using namespace std;

#define ll long long

int n, m;
vector<ll> cookie;
ll mx = 0;

bool check(ll len){
    if(len == 0) return false;

    int cnt = 0;

    for(auto c : cookie){
        cnt += (c/len);
        if(cnt >= m) return true;
    }
    return false;
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> m >> n;
    cookie.resize(n);
    for(int i=0; i<n; i++) {
        cin >> cookie[i];
        mx = max(mx, cookie[i]);
    }

    sort(cookie.begin(), cookie.end());

    ll st = 1;
    ll en = mx;
    ll answer = 0;
    while(st <= en){
        ll mid = (st+en) / 2;
        if(check(mid)){
            st = mid + 1;
            answer = mid;
        }
        else {
            en = mid - 1;
        }
    }

    cout << answer;
}
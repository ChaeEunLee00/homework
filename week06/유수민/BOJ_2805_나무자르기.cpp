#include <bits/stdc++.h>
using namespace std;

#define ll long long

ll n, m;
ll mx = 0;
vector<ll> tree;


bool check(ll hei){

    ll sm = 0;
    for(int i=0; i<n; i++){
        if(tree[i] > hei) sm += (tree[i] - hei);
    }

    return sm >= m;
}


int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> m;
    tree.resize(n);
    for(int i=0; i<n; i++) {
        cin >> tree[i];
        mx = max(tree[i], mx);
    }

    ll st = 0;
    ll en = mx;
    ll answer = st;

    while(st <= en){
        ll mid = (st + en) / 2; // 절단기 설정 높이
        if(check(mid)){
            st = mid + 1;
            answer = mid;
        }
        else{
            en = mid - 1;
        }
    }

    cout << answer;
}
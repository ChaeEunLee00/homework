#include <bits/stdc++.h>
using namespace std;

int n;
int a[1000001];
vector<int> v;


int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> n;
    for(int i=1; i<=n; i++) cin >> a[i];

    v.push_back(a[1]);

    for(int i=2; i<=n; i++){
        if(v.back() < a[i]) v.push_back(a[i]);
        else {
            int idx = lower_bound(v.begin(), v.end(), a[i]) - v.begin();
            v[idx] = a[i];
        }
    }

    cout << v.size();
}
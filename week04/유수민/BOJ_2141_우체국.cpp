#include <bits/stdc++.h>
using namespace std;

int n;
#define X first
#define Y second
#define pii pair<long long, long long>

vector<pii> house;

int main(){
    cin >> n;
    long long tot = 0;
    long long x, y;
    for(int i=1; i<=n; i++){
        cin >> x >> y;
        house.push_back({x, y});
        tot += y;
    }

    sort(house.begin(), house.end());

    int temp = 0;
    if(tot % 2 != 0) temp = 1;
    long long mid = tot / 2 + temp;
    tot = 0;
    long long answer = 0;

    for(int i=0; i<n; i++){
        if(tot < mid && tot+house[i].Y >= mid){
            answer = house[i].X;
            break;
        }
        tot += house[i].Y;
    }
    cout << answer;
}
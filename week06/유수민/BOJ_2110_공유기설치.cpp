#include <bits/stdc++.h>
using namespace std;

int n, c;
vector<int> wifi;

// 1 2 4 8 9
// 1 2 3 50 60
// 1 50 55
// 50 60 80
bool check(int dist){

    int cnt = 1;
    int last_idx = 0;

    for(int i=1; i<wifi.size(); i++){
        if(wifi[i] - wifi[last_idx] >= dist){
            cnt++;
            last_idx = i;
        }
    }
    return cnt >= c;

}

// 가장 인접한 두 공유기 사이의 거리 최대로
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> c;
    wifi.resize(n);

    for(int i=0; i<n; i++){
        cin >> wifi[i];
    }

    sort(wifi.begin(), wifi.end());

    int st = 1;
    int en = wifi[wifi.size()-1];
    int answer = 1;
    while(st <= en){
        int mid = (st+en)/2;
        if(check(mid)){
            st = mid + 1;
            answer = mid;
        }
        else{
            en = mid - 1;
        }
    }

    cout << answer;

    return 0;
}
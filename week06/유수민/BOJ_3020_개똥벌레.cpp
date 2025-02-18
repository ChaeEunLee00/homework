#include<bits/stdc++.h>
using namespace std;

int n, h;

vector<int> b1;
vector<int> b2;
int mn = INT_MAX;
int cnt = 0;


bool check(int r){ // r개의 장애물이 가능한가?
    
    // 1 ~ h 구간 확인해야됨.
    for(int i=1; i<=h; i++){
        int count = 0;

        int idx1 = upper_bound(b1.begin(), b1.end(), i-1) - b1.begin();
        count += (n/2-idx1);
        int idx2 = upper_bound(b2.begin(), b2.end(), i-1) - b2.begin();
        count += idx2;
        if(count <= r) return true;
    }

    return false;
}

void findCnt(){
    for(int i=1; i<=h; i++){
        int count = 0;
        int idx1 = upper_bound(b1.begin(), b1.end(), i-1) - b1.begin();
        count += (n/2-idx1);
        int idx2 = upper_bound(b2.begin(), b2.end(), i-1) - b2.begin();
        count += idx2;
        if(count == mn) cnt++;
    }
}

int main(){

    // 석순(아래) -> 종유석(위)
    cin >> n >> h;
    for(int i=1; i<=n; i++){
        int t;
        cin >> t;
        if(i % 2 == 1) b1.push_back(t); // 홀수
        else b2.push_back(h-t); // 짝수
    }

    sort(b1.begin(), b1.end());
    sort(b2.begin(), b2.end());

    int st = 0;
    int en = n;

    while(st <= en){
        int mid = (st + en) / 2; // 파괴해야 하는 장애물의 최솟값
        if(check(mid)){
            en = mid - 1;
            mn = mid;
        }
        else{
            st = mid + 1;
        }
    }

    findCnt();

    cout << mn <<  " " << cnt; 
}
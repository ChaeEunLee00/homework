#include <bits/stdc++.h>
using namespace std;

#define ll long long

long long solution(int n, vector<int> times) {
    
    sort(times.begin(), times.end());
    
    ll st = 1;
    ll en = pow(10, 18);
    ll answer = en;
    
    while(st <= en){
        ll mid = (st + en) / 2; // 걸리는 시간 (최소)
        
        ll count = 0;
        for(auto t : times) count += (mid/t);
        bool check = (count >= n ? true : false);
         
        if(check){
            answer = mid;
            en = mid - 1;
        }
        else{
            st = mid + 1;
        }
    }
    
    
    return answer;
}
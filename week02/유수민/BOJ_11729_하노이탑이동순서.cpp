#include <bits/stdc++.h>
using namespace std;

// 2번 : 보조기둥
// 3번 : 목적기둥 

/*
하노이 탑 문제의 규칙

1. 크기가 n인 하노이 탑 문제를 풀기 위해, 먼저 상위 n−1개의 디스크를 보조 기둥으로 이동.
2. 가장 큰 디스크를 목적 기둥으로 이동.
3. 보조 기둥에 있던 n−1개의 디스크를 목적 기둥으로 이동.

*/

int n;
vector<pair<int, int>> answer;

void hanoi(int num, int start, int end, int temp){

    if(num == 1){
        answer.push_back({start, end});
    }
    else{

        hanoi(num-1, start, temp, end);
        answer.push_back({start, end});
        hanoi(num-1, temp, end, start);
    }

}

int main(){

    cin >> n;
    hanoi(n, 1, 3, 2);
    cout << answer.size() << "\n";
    for(auto e : answer) cout << e.first << " " << e.second << "\n";
    
}
#include <bits/stdc++.h>
using namespace std;

int n;
int ans;

bool isused1[20]; // 아래로
bool isused2[20]; // 왼쪽으로
bool isused3[20]; // 오른쪽으로

void calc(int cur){

    if(cur == n){
        ans++;
        return;
    }

    for(int i=0; i<n; i++){
        if(isused1[i] || isused2[i+cur] || isused3[cur-i+n-1]) continue;

        isused1[i] = true;
        isused2[i+cur] = true;
        isused3[cur-i+n-1] = true;
        calc(cur+1);
        isused1[i] = false;
        isused2[i+cur] = false;
        isused3[cur-i+n-1] = false;

    }


}

int main(){

    cin >> n;

    calc(0);

    cout << ans;
}
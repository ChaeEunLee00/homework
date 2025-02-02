#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

int n;
pii tabs[1001];
int answer = 0;


int main(){
    cin >> n;

    for(int i=1; i<=n; i++){
        cin >> tabs[i].X;
    }
    for(int i=1; i<=n; i++){
        cin >> tabs[i].Y;
    }

    answer += abs(tabs[1].Y - tabs[1].X);
    int cur = tabs[1].Y - tabs[1].X; // 앞 줄 횟수 기록

    for(int i=2; i<=n; i++){
        int res = tabs[i].Y - tabs[i].X;
        if(res * cur > 0){ // 같은 그룹
            if(abs(cur) > abs(res)){
                cur = res;
            }
            else if(abs(cur) < abs(res)){
                answer += (abs(res) - abs(cur));
                cur = res;
            }
        } 
        else{
            answer += abs(res);
            cur = res;
        }
    }


    cout << answer;
}
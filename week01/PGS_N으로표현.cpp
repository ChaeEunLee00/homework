#include <bits/stdc++.h>

using namespace std;

vector<int> dp[10];

void makes(int N, int cnt){
    int res = N;
    int e = cnt-1;
    int ten = 1;
    while(e--){
        ten *= 10;
        res += (N * ten);
    }
    dp[cnt].push_back(res);
}

int solution(int N, int number) {
    int answer = 0;
    
    dp[0].push_back(0);
    dp[1].push_back(N);
    
    for(int i=2; i<=9; i++){ // N을 사용하는 횟수
        int mid = i/2;
        makes(N, i);
        
        for(int j=1; j<=mid; j++){
            
            int num = 0;
            for(int e1 : dp[j]){
                for(int e2 : dp[i-j]){
                    if(e1 == number || e2 == number) return i-1;
                    
                    num = e1 + e2;
                    if(num > 0) dp[i].push_back(num);
                    num = abs(e1 - e2);
                    if(num > 0) dp[i].push_back(num);
                    num = e1 * e2;
                    if(num > 0) dp[i].push_back(num);
                    num = e1 > e2 ?  e1 / e2 : e2 / e1;
                    if(num > 0) dp[i].push_back(num);

                }
            }
        }
    }

    return -1;
}

int main(){
    cout << solution(5, 12);
}
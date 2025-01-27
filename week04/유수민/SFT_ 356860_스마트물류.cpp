#include<bits/stdc++.h>
using namespace std;

int n, k;
char line[20001];
// P로봇 H부품
int gets[20001];
bool isTaken[20001];

int main(int argc, char** argv)
{
    cin >> n >> k;

    for(int i=1; i<=n; i++){
        cin >> line[i];
    }

    for(int i=1; i<=n; i++){
        if(line[i] == 'H') continue;
        
        for(int j=i-k; j<i; j++){
            if(j < 1) continue;

            if(line[j]=='H' && !isTaken[j]){
                gets[i] = j;
                isTaken[j] = true;
                break;
            }
        }
        if(gets[i] != 0) continue;
        
        for(int j=i+1; j<=i+k; j++){
            if(j > n) continue;
            if(line[j]=='H' && !isTaken[j]){
                gets[i] = j;
                isTaken[j] = true;
                break;
            }
        }
    }

    int answer = 0;
    for(int i=1; i<=n; i++){
        if(gets[i] != 0) answer++;
    }

    cout << answer;
   return 0;
}
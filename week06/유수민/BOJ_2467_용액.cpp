#include <bits/stdc++.h>
using namespace std;

vector<int> li;
int n;

int main(){

    cin >> n;
    li.resize(n);

    for(int i=0; i<n; i++){
        cin >> li[i];
    }

    // 인덱스를 가리킴
    int st = 0;
    int en = n-1;

    int mn = abs(li[st] + li[en]);
    int a1 = li[st], a2 = li[en];

    while(st < en){
        int mid = (li[st] + li[en]);

        if(abs(0 - mid) < mn){
            //cout << mid << " ";
            mn = abs(0 - mid);
            a1 = li[st];
            a2 = li[en];
        }
        
        if(mid < 0){
            st++;
        }
        else{
            en--;
        }
    }

    cout << a1 << " " << a2;
    
}
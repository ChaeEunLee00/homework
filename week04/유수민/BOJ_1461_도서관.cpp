#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> books1; // 음수
vector<int> books2; // 양수

int main(){

    cin >> n >> m;

    int b;
    int mx = 0;
    int check = 0;
    for(int i=0; i<n; i++){
        cin >> b;
        if(b>0) {
            books2.push_back(b);
            if(b > mx){
                mx = b;
                check = 1;
            }
        }
        else {
            books1.push_back(-1*b);
            if(-1*b > mx){
                mx = -1*b;
                check = -1;
            }
        }

        
    }

    sort(books1.begin(), books1.end(), greater<int>());
    sort(books2.begin(), books2.end(), greater<int>());
    
    int ans = 0;
    for(int i=0; i<books1.size(); i+=m){
        if(i==0 && check == -1){
            ans += books1[i];
            continue;
        }
        ans += 2 * books1[i];
    }
    for(int i=0; i<books2.size(); i+=m){
        if(i==0 && check == 1){
            ans += books2[i];
            continue;
        }
        ans += 2 * books2[i];
    }

    cout << ans;

}
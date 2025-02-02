#include <bits/stdc++.h>
using namespace std;

int n, k;
string str;

int main(){
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(0);

    cin >> n >> k;
    cin >> str;

    stack<char> s;

    for(int i=0; i<n; i++){
        
        while(!s.empty() && s.top() < str[i] && k>0){
            k--;
            s.pop();

        }
        s.push(str[i]);
    }

    while(k > 0){
        s.pop();
        k--;
    }

    vector<char> res;

    while(!s.empty()){
        res.push_back(s.top());
        s.pop();
    }
    reverse(res.begin(), res.end());

    for(auto e : res) cout << e;
    

}
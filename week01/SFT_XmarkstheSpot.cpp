#include<bits/stdc++.h>
using namespace std;

int n;
string s, t;

char func(char c){
    if('a' <= c && c <= 'z') return 'A' + (c - 'a');
    else return c;
}

int main(int argc, char** argv)
{
    cin >> n;
    string ans = "";
    for(int i=0; i<n; i++){
        cin >> s >> t;

        int idx = 0;
        for(int e=0; e<s.size(); e++){
            if(s[e] == 'X' || s[e] == 'x'){
                idx = e;
                break;
            }
        }
        
        ans += func(t[idx]);
    }
    

    cout << ans;
    

   return 0;
}
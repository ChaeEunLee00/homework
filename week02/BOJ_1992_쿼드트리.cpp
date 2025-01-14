#include <bits/stdc++.h>
using namespace std;

int n;
int board[65][65];

void func(int x, int y, int sz){

    int r = board[x][y];
    bool b = true;
    for(int i=x; i<x+sz; i++){
        for(int j=y; j<y+sz; j++){
            if(board[i][j] != r) {
                b = false;
                break;
            }
        }
    }

    if(b){
        cout << r;
        return;
    }

    cout << "(";
    func(x, y, sz/2);
    func(x, y+sz/2, sz/2);
    func(x+sz/2, y, sz/2);
    func(x+sz/2, y+sz/2, sz/2);
    cout << ")";
}


int main(){

    cin >> n;

    string s;
    bool b = true;
    for(int i=0; i<n; i++){
        cin >> s;
        for(int j=0; j<s.size(); j++){
            board[i][j] = s[j] - '0';
        }
    }

    func(0, 0, n);

}
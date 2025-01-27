#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>

int board[50][50];

vector<pii> black;
vector<pii> white;

int x, y;

bool check(int i, int j){

    if(board[i][j] == board[i+1][j+1] &&
    board[i][j] == board[i+2][j+2] &&
    board[i][j] == board[i+3][j+3] &&
    board[i][j] == board[i+4][j+4] &&
    board[i][j] != board[i+5][j+5] &&
    board[i][j] != board[i-1][j-1]){
        x = i, y = j;
        return true;
    }

    else if(board[i][j] == board[i-1][j+1] &&
    board[i][j] == board[i-2][j+2] &&
    board[i][j] == board[i-3][j+3] &&
    board[i][j] == board[i-4][j+4] &&
    board[i][j] != board[i-5][j+5] &&
    board[i][j] != board[i+1][j-1]){
        x = i, y = j;
        return true;
    }

    else if(board[i][j] == board[i][j+1] &&
    board[i][j] == board[i][j+2] &&
    board[i][j] == board[i][j+3] &&
    board[i][j] == board[i][j+4] &&
    board[i][j] != board[i][j+5] &&
    board[i][j] != board[i][j-1]){
        x = i, y = j;
        return true;
    }

    else if(board[i][j] == board[i+1][j] &&
    board[i][j] == board[i+2][j] &&
    board[i][j] == board[i+3][j] &&
    board[i][j] == board[i+4][j] &&
    board[i][j] != board[i+5][j] &&
    board[i][j] != board[i-1][j]){
        x = i, y = j;
        return true;
    }

    return false;
}

int main(){
    for(int i=21; i<=39; i++){
        for(int j=21; j<=39; j++){
            cin >> board[i][j];
            if(board[i][j] == 1) black.push_back({i, j});
            else if(board[i][j] == 2) white.push_back({i, j});
        }
    }

    bool bWin = false;
    for(pii b : black){
        bWin = check(b.X, b.Y);
        if(bWin) break;
    }
    if(bWin){
        cout << 1 << "\n" << x-20 << " " << y-20;
        return 0;
    }

    bool wWin = false;
    for(pii w : white){
        wWin = check(w.X, w.Y);
        if(wWin) break;
    }
    if(wWin){
        cout << 2 << "\n" << x-20 << " " << y-20;
        return 0;
    }
    
    cout << 0;
    return 0;

}
#include <bits/stdc++.h>
using namespace std;

int state[4][8];
bool b[4];
int direction[4];

// N : 0, S : 1
// 시계 : 1, 반시계 : -1

void rotate(int num, int dir){
    if(dir == -1){
        int temp = state[num][0];
        for(int i=0; i<7; i++){
            state[num][i] = state[num][i+1];
        }
        state[num][7] = temp;
    }
    else{
        int temp = state[num][7];
        for(int i=7; i>0; i--){
            state[num][i] = state[num][i-1];
        }
        state[num][0] = temp;
    }
}

void calc(int num, int dir){

    direction[num] = dir;
    b[num] = true;

    switch(num){
        case 0:
            if(state[0][2] != state[1][6]) {
                b[1] = true;
                direction[1] = dir * -1;
            }
            if(b[1] == true && state[1][2] != state[2][6]){
                b[2] = true;
                direction[2] = direction[1] * -1;
            }
            if(b[2] == true && state[2][2] != state[3][6]){
                b[3] = true;
                direction[3] = direction[2] * -1;
            }
            break;
        case 1:
            if(state[1][6] != state[0][2]){
                b[0] = true;
                direction[0] = dir * -1;
            }
            if(state[1][2] != state[2][6]){
                b[2] = true;
                direction[2] = dir * -1;
            }
            if(b[2] == true && state[2][2] != state[3][6]){
                b[3] = true;
                direction[3] = direction[2] * -1;
            }
            break;

        case 2:
            if(state[2][2] != state[3][6]){
                b[3] = true;
                direction[3] = dir * -1;
            }
            if(state[2][6] != state[1][2]){
                b[1] = true;
                direction[1] = dir * -1;
            }
            if(b[1] == true && state[1][6] != state[0][2]){
                b[0] = true;
                direction[0] = direction[1] * -1;
            }
            break;

        case 3:
            if(state[3][6] != state[2][2]){
                b[2] = true;
                direction[2] = dir * -1;
            }
            if(b[2] == true && state[2][6] != state[1][2]){
                b[1] = true;
                direction[1] = direction[2] * -1;
            }
            if(b[1] == true && state[1][6] != state[0][2]){
                b[0] = true;
                direction[0] = direction[1] * -1;
            }
            break;
    }

    for(int i=0; i<4; i++){
        if(b[i] == true) {
            rotate(i, direction[i]);
        }
    }

}

int main(){

    string str;
    for(int i=0; i<4; i++){
        cin >> str;
        for(int j=0; j<8; j++){
            state[i][j] = str[j] - '0';
        }
    }
    

    int k;
    cin >> k;
    int num, dir;
    for(int i=0; i<k; i++){
        cin >> num >> dir;
        fill(b, b+4, false);
        calc(num-1, dir);
    }

    

    int answer = 0;
    if(state[0][0] == 1) answer += 1;
    if(state[1][0] == 1) answer += 2;
    if(state[2][0] == 1) answer += 4;
    if(state[3][0] == 1) answer += 8;

    cout << answer;

}
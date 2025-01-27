#include <bits/stdc++.h>
using namespace std;

char game[31][31];

int solution(int m, int n, vector<string> board) {
    int answer = 0;

    
    while(1){
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                game[i][j] = board[i][j];
            }
        }
        
        int cnt = 0;
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){

                if(board[i][j] != '0'
                   && board[i][j] == board[i+1][j] 
                   && board[i+1][j] == board[i][j+1] 
                   && board[i][j+1] == board[i+1][j+1]){
                    
                    if(game[i][j] != '0') cnt++;
                    game[i][j] = '0';
                    
                    if(game[i+1][j] != '0') cnt++;
                    game[i+1][j] = '0';
                    
                    if(game[i][j+1] != '0') cnt++;
                    game[i][j+1] = '0';
                    
                    if(game[i+1][j+1] != '0') cnt++;
                    game[i+1][j+1] = '0';
                }
            }
        }
        if(cnt == 0) break;
        answer += cnt;
        
        for(int j=0; j<n; j++){
            stack<char> st;
            
            for(int i=0; i<m; i++){
                if(game[i][j] != '0') st.push(game[i][j]);
            }
            for(int i=m-1; i>=0; i--){
                if(st.empty()) {
                    board[i][j] = '0';
                    continue;
                }
                auto cur = st.top();
                st.pop();
                board[i][j] = cur;
            }
        }
        
    }
    
    
    return answer;
}
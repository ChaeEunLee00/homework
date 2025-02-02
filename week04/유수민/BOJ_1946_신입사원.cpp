#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define pii pair<int,int>


int n;
pii ranks[100001];
vector<int> ans;


int main(){
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(false);


    int t;
    cin >> t;
    
    while(t--){
        cin >> n;
        int answer = 0;

        for(int i=1; i<=n; i++){
            int x, y;
            cin >> x >> y;

            ranks[i] = {x, y};
        }
        sort(ranks+1, ranks+n+1);

        int r2 = ranks[1].Y;
        answer++;
        
        for(int i=2; i<=n; i++){
            // cout << ranks[i].X << " " << ranks[i].Y <<"\n";
            if(ranks[i].Y < r2) {
                answer++;
                r2 = ranks[i].Y;
            }
        }
 
        ans.push_back(answer);
    }

    for(auto e : ans) cout << e << "\n";
    
}
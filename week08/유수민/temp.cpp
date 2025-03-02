#include <bits/stdc++.h>
using namespace std;

int main() {
    // 사용할 수 있는 최대 비용
    int money = 900;
    // 각 층의 수리 비용 (예시: 0층부터 순서대로)
    vector<int> cost = {0, 800, 300, 200, 100};

    int n = cost.size();
    int maxLen = 0;
    
    int left = 0;
    int right = 0;
    int currentSum = cost[left];
    
    // end 포인터를 이용하여 오른쪽으로 확장하면서 currentSum을 갱신합니다.
    while(left <= right && right < cost.size()){

        if(currentSum <= money){
            maxLen = max(maxLen, right - left + 1);
            currentSum += cost[++right];
        }
        else{

            if(left == right){
                currentSum = cost[++left];
                right++;
            }
            else{
                currentSum -= cost[left++];
            }
        }
    }
    
    cout << "수리할 수 있는 연속하는 최대 층의 길이: " << maxLen << endl;

    vector<int> vv = {0, 1};
    int sum = 0;
    sum += vv[1];
    cout << sum << "!";
    
    return 0;
}
#include <bits/stdc++.h>
using namespace std;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) 
{
    long long answer = 0;

    int start = -1;
    int idx = -1;
    int give = 0;
    int get = 0;
    for(int i=n-1 ;i>=0;--i)
    {
        if(deliveries[i]!=0 || pickups[i]!=0)
        {
            int cnt=0;
            while(give < deliveries[i] || get< pickups[i])
            {
                ++cnt;
                give+=cap;
                get+=cap;
            }
            give -= deliveries[i];
            get -=  pickups[i];
            answer = answer + (long long)((i+1)*cnt*2);
        }
    }
    return answer;
}
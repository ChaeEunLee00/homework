#include <bits/stdc++.h>
using namespace std;

int l, c;
vector<char> v;

bool check(string str){

    int mo = 0;
    int ja = 0;

    for(auto s : str){
        if(s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') mo++;
        else ja++;
    }

    if(mo >=1 && ja >=2) return true;
    else return false;
}

void func(string str, int idx){

    if(str.size() == l && check(str)){
        cout << str << "\n";
        return;
    }

    if(idx == c) return;
    
    if(str == ""){
        string temp = "";
        temp += v[idx];
        func(temp, idx+1);
        func("", idx+1);
    }
    else{
        func(str+v[idx], idx+1);
        func(str, idx+1);
    }
}

int main(){
    cin >> l >> c;

    char a;
    for(int i=0; i<c; i++){
        cin >> a;
        v.push_back(a);
    }

    sort(v.begin(), v.end());

    func("", 0);
}
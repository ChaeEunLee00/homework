#include <bits/stdc++.h>

using namespace std;

bool correct(string str){
    
    stack<char> st;
    for(auto e : str){
        if(e == '('){
            st.push(e);
        }
        else{
            if(st.empty()) return false;
            
            if(st.top() == '(') st.pop();
            else return false;
        }
    }
    if(st.empty()) return true;
    else return false;
}

string func(string str){
    
    if(str == "") return "";
    
    
    string u = "";
    string v = "";
    
    int l1 = 0, l2 = 0;
    
    if(str[0] == '(') l1++;
    else l2++;
    u += str[0];
    
    for(int i=1; i<str.size(); i++){
        if(str[i] == '(') l1++;
        else l2++;
        u += str[i];
        if(l1 == l2) {
            for(int j=i+1; j<str.size(); j++) v += str[j];
            break;
        }
    }
    
    if(correct(u) == true){   
        return u + func(v);
    }
    
    string temp = "";
    temp += "(";
    temp += func(v);
    temp += ")";

    for(int i=1; i<u.size()-1; i++){
        if(u[i] == '(') temp += ")";
        else temp += "(";
    }
    return temp;
    
}

string solution(string p) {

    string answer = "";
    
    answer = func(p);
    
    return answer;
}
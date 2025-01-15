import java.util.*;

class Solution {
    public String solution(String p) {
        StringBuilder sb = new StringBuilder();

        sb.append(recursion(p));

        return sb.toString();
    }

    static String recursion(String p){
        if(p.equals("")) return "";
        else if(isRight(p)) return p;

        StringBuilder sb = new StringBuilder();

        // u,v 나누기
        int idx = partition(p);
        String u = p.substring(0,idx);
        String v = p.substring(idx);

        // u가 올바르다면
        if(isRight(u)) {
            sb.append(u);
            sb.append(recursion(v));
            return sb.toString();
        }
        // u가 올바르지 않다면
        else {
            sb.append("(");
            sb.append(recursion(v));
            sb.append(")");
            sb.append(change(u));

            return sb.toString();
        }
    }

    static int partition(String p){
        int count1 = 0;
        int count2 = 0;

        int idx = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') count1++;
            else count2++;

            if(count1 == count2){
                idx = i+1;
                break;
            }
        }

        return idx;
    }

    static boolean isRight(String p){
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '('){
                stk.push('(');
            }
            else{
                if(stk.isEmpty()){
                    return false;
                }
                else{
                    stk.pop();
                }
            }
        }

        if(!stk.isEmpty()) return false;

        return true;
    }

    static String change(String p){
        //u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < p.length()-1; i++){
            if(p.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }

        return sb.toString();
    }
}
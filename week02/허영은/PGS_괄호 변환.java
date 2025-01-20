class Solution {
    public String solution(String p) {
        String answer = "";
        if("".equals(p) || checkYn(p)) return p;
        
        return dfs(p);
    }
    
    public String dfs(String p){
        
        if(checkYn(p)) return p;
            
        int cnt = 0;
        String u = "";
        String v = "";
        for(int i = 0; i<p.length(); i++){
            String tmp = p.substring(i,i+1);
            
            if("(".equals(tmp)){
                cnt++;
            }else if(")".equals(tmp)){
                cnt--;
            }
            
            if(cnt == 0){
                u = p.substring(0,i+1);
                v = p.substring(i+1);
                break;
            }
        }
        
        if(checkYn(u)){
            return u + dfs(v);
        }else{
            String str = "";
            for(int i = 1; i<u.length()-1; i++){
                if("(".equals(u.substring(i,i+1))){
                    str += ")";
                }else{
                    str += "(";
                }
            }
            
            return "(" + dfs(v) + ")" + str;
        }
    }
    
    // 올바른 괄호 문자열 체크
    public boolean checkYn(String str){
        int cnt = 0;
        for(int i = 0; i<str.length(); i++){
            String tmp = str.substring(i,i+1);
            
            if("(".equals(tmp)){
                cnt++;
            }else if(")".equals(tmp)){
                cnt--;
            }
            
            if(cnt < 0) return false;
        }
        
        return true;
    }
}
출처: https://ansdyd23.tistory.com/88 [일어나 코드짜야지:티스토리]

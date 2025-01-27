# 올바른 괄호 문자열인지 확인
def check_right(u):
    stack = []
    for i in u:
        if i == '(':
            stack.append(i)
        else:
            if not stack:
                return False
            stack.pop()
    return True

# 문자열 w를 u, v로 분리
def seperate_string(w):
    left, right = 0, 0
    for i in range(len(w)):
        if w[i] == '(':
            left += 1
        else:
            right += 1
        if left == right:
            return w[:i+1], w[i+1:]

def solution(p):
    
    if not p:
        return ""
    
    answer = ''
    u, v = seperate_string(p)
    
    if check_right(u):
        answer = u + solution(v)
    else:
        answer += '('
        answer += solution(v)
        answer += ')'
        
        temp = u[1:-1]
        for i in temp:
            if i == '(':
                answer += ')'
            else:
                answer += '('
        
    return answer
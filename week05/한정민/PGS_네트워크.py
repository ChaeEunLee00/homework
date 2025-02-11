def solution(n, computers):
    answer = 0
    visited = [False] * n
    for i in range(n):
        if not visited[i]:
            answer += 1
            dfs(i, n, computers, visited)
    return answer

def dfs(v, n, computers, visited):
    visited[v] = True
    for i in range(n):
        if computers[v][i] == 1 and i != v and not visited[i]:
            dfs(i, n, computers, visited)    
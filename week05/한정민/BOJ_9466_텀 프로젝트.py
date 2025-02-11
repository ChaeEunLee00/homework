import sys
sys.setrecursionlimit(10**6)

def dfs(v):
    global team
    visited[v] = True
    cycle.append(v)
    next = students[v]

    if not visited[next]:
        dfs(next)
    else:
        if next in cycle:
            team += cycle[cycle.index(next):]
            return  

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    n = int(input())
    students = [0] + list(map(int, input().split()))
    visited = [False] * (n+1)
    team = []

    for i in range(1, n+1):
        if not visited[i]:
            cycle = []
            dfs(i)
    
    print(n - len(team))
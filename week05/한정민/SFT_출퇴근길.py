import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline
n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
reverse_graph = [[] for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    reverse_graph[y].append(x)

s, t = map(int, input().split())

def dfs(now, graph, visited):
    if visited[now] == True:
        return 
    visited[now] = True
    for node in graph[now]:
        dfs(node, graph, visited)

fromS = [False] * (n+1)
fromS[t] = True
dfs(s, graph, fromS)

fromT = [False] * (n+1)
fromT[s] = True
dfs(t, graph, fromT)

toS = [False] * (n+1)
dfs(s, reverse_graph, toS)

toT = [False] * (n+1)
dfs(t, reverse_graph, toT)

count = 0
for i in range(1, n+1):
    if fromS[i] and fromT[i] and toS[i] and toT[i]:
        count += 1
print(count - 2) # S, T 제외
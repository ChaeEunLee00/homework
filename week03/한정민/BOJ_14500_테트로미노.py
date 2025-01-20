import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

visited = [[False] * m for _ in range(n)]
max_sum = max(map(max, graph))
answer = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, depth, current):
    global answer
    
    if current + max_sum * (4 - depth) <= answer:
        return
    
    if depth == 4:
        answer = max(answer, current)
        return
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:

            # 'ㅜ' 모양
            if depth == 2:
                visited[nx][ny] = True
                dfs(x, y, depth + 1, current + graph[nx][ny])
                visited[nx][ny] = False
            
            visited[nx][ny] = True
            dfs(nx, ny, depth + 1, current + graph[nx][ny])
            visited[nx][ny] = False

for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i, j, 1, graph[i][j])
        visited[i][j] = False

print(answer)
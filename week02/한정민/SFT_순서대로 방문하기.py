import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
data = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

for _ in range(m):
    x, y = map(int, input().split())
    # 방문해야 하는 지점 2로 표시
    graph[x-1][y-1] = 2
    data.append((x-1, y-1))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(level, x, y):
    if level == m:
        return 1

    count = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        if graph[nx][ny] == 0:
            graph[nx][ny] = 1
            count += dfs(level, nx, ny)
            graph[nx][ny] = 0
        elif graph[nx][ny] == 2 and nx == data[level][0] and ny == data[level][1]:
            graph[nx][ny] = 1
            count += dfs(level + 1, nx, ny)
            graph[nx][ny] = 2
    return count

graph[data[0][0]][data[0][1]] = 1
print(dfs(1, data[0][0], data[0][1]))
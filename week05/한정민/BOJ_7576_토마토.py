import sys
from collections import deque

input = sys.stdin.readline
m, n = map(int, input().split())
tomatoes = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    queue = deque()
    for i in range(n):
        for j in range(m):
            if tomatoes[i][j] == 1:
                queue.append((i, j))
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and tomatoes[nx][ny] == 0:
                tomatoes[nx][ny] = tomatoes[x][y] + 1
                queue.append((nx, ny))

    if any(0 in row for row in tomatoes):
        print(-1)
    else:
        print(max(max(row) for row in tomatoes) - 1)

bfs()
import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())
board = [list(input().rstrip()) for _ in range(n)]

ghost = []
namwoo = []
ghost_visited = [[0] * m for _ in range(n)]
namwoo_visited = [[0] * m for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

# 유령 BFS
def ghost_bfs():
    queue = deque(ghost)

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            if ghost_visited[nx][ny] > 0:
                continue
            
            queue.append((nx, ny))
            ghost_visited[nx][ny] = ghost_visited[x][y] + 1

# 남우 BFS
def namwoo_bfs():
    queue = deque(namwoo)

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            if namwoo_visited[nx][ny] > 0:
                continue

            if board[nx][ny] == '#':
                continue

            if ghost_visited[nx][ny] > 0 and ghost_visited[nx][ny] <= namwoo_visited[x][y] + 1:
                continue

            queue.append((nx, ny))
            namwoo_visited[nx][ny] = namwoo_visited[x][y] + 1
        
            if board[nx][ny] == 'D':
                print("Yes")
                return
        
    print("No")

for i in range(n):
    for j in range(m):
        if board[i][j] == 'G':
            ghost.append((i, j))
            ghost_visited[i][j] = 1
        elif board[i][j] == 'N':
            namwoo.append((i, j))
            namwoo_visited[i][j] = 1

ghost_bfs()
namwoo_bfs()
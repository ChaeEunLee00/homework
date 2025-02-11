import sys
from collections import deque

input = sys.stdin.readline
r, c = map(int, input().split())
graph = [list(input().rstrip()) for _ in range(r)]

jihun = []
fire = []
jihun_visited = [[-1] * c for _ in range(r)]
fire_visited = [[-1] * c for _ in range(r)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def fire_bfs():
    queue = deque(fire)

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < r and 0 <= ny < c and fire_visited[nx][ny] == -1 and graph[nx][ny] != '#':
                fire_visited[nx][ny] = fire_visited[x][y] + 1
                queue.append((nx, ny))

def jihun_bfs():
    queue = deque(jihun)

    while queue:
        x, y = queue.popleft()

        # 가장자리에 도달하면 탈출
        if x == 0 or x == r - 1 or y == 0 or y == c - 1:
            print(jihun_visited[x][y] + 1)
            return
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < r and 0 <= ny < c:
                if graph[nx][ny] == '#' or jihun_visited[nx][ny] != -1:
                    continue

                if fire_visited[nx][ny] == -1 or jihun_visited[x][y] + 1 < fire_visited[nx][ny]:
                    jihun_visited[nx][ny] = jihun_visited[x][y] + 1
                    queue.append((nx, ny))

    print("IMPOSSIBLE")

for i in range(r):
    for j in range(c):
        if graph[i][j] == 'J':
            jihun.append((i, j))
            jihun_visited[i][j] = 0
        elif graph[i][j] == 'F':
            fire.append((i, j))
            fire_visited[i][j] = 0

fire_bfs()
jihun_bfs()
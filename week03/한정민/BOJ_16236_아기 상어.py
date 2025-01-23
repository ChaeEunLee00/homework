import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

x, y, size = 0, 0, 2
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            x, y = i, j

def bfs(x, y, size):
    distance = [[0] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]

    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    fish = []

    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == False:
                if graph[nx][ny] <= size:
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    distance[nx][ny] = distance[cx][cy] + 1
                    if graph[nx][ny] < size and graph[nx][ny] != 0:
                        fish.append((nx, ny, distance[nx][ny]))
    
    return sorted(fish, key = lambda x: (-x[2], -x[0], -x[1]))

answer = 0 # 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간
fish_cnt = 0 # 지금까지 먹은 물고기의 수

while True:
    shark = bfs(x, y, size)
    
    if len(shark) == 0:
        break
    
    nx, ny, dist = shark.pop()
    answer += dist
    graph[x][y], graph[nx][ny] = 0, 0

    # 아기 상어 위치 업데이트
    x, y = nx, ny
    fish_cnt += 1
    if fish_cnt == size:
        size += 1
        fish_cnt = 0

print(answer)
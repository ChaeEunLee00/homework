from collections import deque

field = [list(input()) for _ in range(12)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

count = 0

def bfs(x, y, color):
    queue = deque([(x, y)])
    puyo = [(x, y)] # 같은 색 뿌요 위치 저장
    visited[x][y] = True

    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            if 0 <= nx < 12 and 0 <= ny < 6 and not visited[nx][ny] and field[nx][ny] == color:
                visited[nx][ny] = True
                queue.append((nx, ny))
                puyo.append((nx, ny))
    
    return puyo

def apply_gravity():
    for j in range(6):
            remaining = [field[i][j] for i in range(12) if field[i][j] != '.']
            for i in range(12 - len(remaining)):
                field[i][j] = '.'
            for i in range(len(remaining)):
                field[12 - len(remaining) + i][j] = remaining[i]

while True:
    bomb = False
    visited = [[False] * 6 for _ in range(12)]

    for i in range(12):
        for j in range(6):
            if field[i][j] != '.' and not visited[i][j]:
                puyo = bfs(i, j, field[i][j])

                if len(puyo) >= 4:
                    bomb = True
                    for x, y in puyo:
                        field[x][y] = '.'
    
    if bomb:
        apply_gravity()
        count += 1
    else:
        break

print(count)
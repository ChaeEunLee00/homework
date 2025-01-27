import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
wall = [[0] * m for _ in range(n)] # 벽을 세운 후의 graph

for _ in range(n):
    graph.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

result = 0

def checkVirus(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < m:
            if wall[nx][ny] == 0:
                wall[nx][ny] = 2
                checkVirus(nx, ny)

def checkSafeArea():
    area = 0
    for i in range(n):
        for j in range(m):
            if wall[i][j] == 0:
                area += 1
    return area

def dfs(count):
    global result

    if count == 3:
        for i in range(n):
            for j in range(m):
                wall[i][j] = graph[i][j]
        for i in range(n):
            for j in range(m):
                if wall[i][j] == 2:
                    checkVirus(i, j)
        result = max(result, checkSafeArea())
        return
    
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                count += 1
                dfs(count)
                graph[i][j] = 0
                count -= 1

dfs(0)
print(result)
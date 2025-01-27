import sys
input = sys.stdin.readline

n, m, x, y, k = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
moves = list(map(int, input().split()))

# 동서북남 순서
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

dice = [0] * 6

def roll_dice(direction):
    global dice
    if direction == 1:    # 동
        dice = [dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]]
    elif direction == 2:  # 서
        dice = [dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]]
    elif direction == 3:  # 북
        dice = [dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]]
    elif direction == 4:  # 남
        dice = [dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]]

for move in moves:
    nx, ny = x + dx[move - 1], y + dy[move - 1]

    if 0 <= nx < n and 0 <= ny < m:
        x, y = nx, ny
        roll_dice(move)

        if graph[nx][ny] == 0:
            graph[nx][ny] = dice[5]
        else:
            dice[5] = graph[nx][ny]
            graph[nx][ny] = 0

        print(dice[0])   
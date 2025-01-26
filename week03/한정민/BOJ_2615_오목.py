import sys
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(19)]

# 아래, 오른쪽 아래 대각선, 오른쪽, 오른쪽 위 대각선
dx = [1, 1, 0, -1]
dy = [0, 1, 1, 1]

def check(x, y, d, count):
    nx = x + dx[d]
    ny = y + dy[d]
    if 0 <= nx < 19 and 0 <= ny < 19 and board[x][y] == board[nx][ny]:
            return check(nx, ny, d, count + 1)
    return count

def game():    
    for i in range(19):
        for j in range(19):
            if board[i][j] != 0:
                for d in range(4):
                    if check(i, j, d, 1) == 5:
                        px = i - dx[d]
                        py = j - dy[d]
                        if 0 <= px < 19 and 0 <= py < 19 and board[px][py] == board[i][j]:
                            continue
                        print(board[i][j])
                        print(i+1, j+1)
                        return
    print(0)

game()
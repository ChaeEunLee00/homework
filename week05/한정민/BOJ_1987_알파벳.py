import sys
input = sys.stdin.readline

r, c = map(int, input().split())
board = [list(input().rstrip()) for _ in range(r)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs():
    max_count = 0
    queue = set()
    queue.add((0, 0, board[0][0]))

    while queue:
        x, y, history = queue.pop()
        max_count = max(max_count, len(history))

        if max_count == 26:
            return max_count
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < r and 0 <= ny < c and board[nx][ny] not in history:
                queue.add((nx, ny, history + board[nx][ny]))
    
    return max_count

print(bfs())
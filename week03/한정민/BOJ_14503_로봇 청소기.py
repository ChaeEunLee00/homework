import sys
input = sys.stdin.readline

n, m = map(int, input().split())
r, c, d = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
    
def clean(x, y, d):
    count = 0
    while True:
        if room[x][y] == 0:
            room[x][y] = 2 # 현재 칸 청소
            count += 1
        
        # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
        for _ in range(4):
            d = (d - 1) % 4 # 반시계 방향으로 90도 회전
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < n and 0 <= y < m and room[nx][ny] == 0:
                x, y = nx, ny
                break
        
        else:
            x, y = x + dx[d] * (-1), y + dy[d] * (-1)
            if room[x][y] == 1:
                print(count)
                return

clean(r, c, d)
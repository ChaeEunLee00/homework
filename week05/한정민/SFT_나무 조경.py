import sys
input = sys.stdin.readline

n = int(input())
trees = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
max_beauty = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(count, total_beauty):
    global max_beauty

    if count == 4:
        max_beauty = max(max_beauty, total_beauty)
        return
    
    for i in range(n):
        for j in range(n):

            if visited[i][j]:
                continue

            for d in range(4):
                ni = i + dx[d]
                nj = j + dy[d]

                if 0 <= ni < n and 0 <= nj < n and not visited[ni][nj]:
                    visited[i][j] = visited[ni][nj] = True
                    new_beauty = trees[i][j] + trees[ni][nj]

                    dfs(count + 1, total_beauty + new_beauty)
                    
                    # 백트래킹
                    visited[i][j] = visited[ni][nj] = False

    max_beauty = max(max_beauty, total_beauty)

dfs(0, 0)
print(max_beauty)
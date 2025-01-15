n = int(input())
count = 0

# 각 행에서의 퀸의 위치를 표시
visited = [-1] * n

# 이전 행의 퀸과 충돌하지 않는지 확인
def check(row):
    for i in range(row):
        # 같은 열 or 대각선
        if visited[row] == visited[i] or row - i == abs(visited[row] - visited[i]):
            return False
    return True

def dfs(row):
    global count

    if row == n:
        count += 1
    else:
        for col in range(n):
            visited[row] = col
            if check(row):
                dfs(row + 1)
    return count

print(dfs(0))
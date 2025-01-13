import sys
input = sys.stdin.readline

n, k = map(int, input().split())
wv = [[0, 0]]
dp = [[0 for _ in range(k+1)] for _ in range(n+1)]

for i in range(n):
    wv.append(list(map(int, input().split())))

for i in range(1, n+1):
    for j in range(1, k+1):
        weight = wv[i][0]
        value = wv[i][1]
        if j < weight:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j-weight] + value, dp[i-1][j])

print(dp[n][k])
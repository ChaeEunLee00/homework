n = int(input())
data = list(map(int, input().split()))
dp = [1] * n

for i in range(1, n):
    for j in range(i):
        if data[j] > data[i]:
            dp[i] = max(dp[j] + 1, dp[i])
        else:
            dp[i] = dp[i-1]

print(max(dp))
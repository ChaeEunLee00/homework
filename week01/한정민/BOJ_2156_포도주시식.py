n = int(input())
glasses = [0] * (n+1)
for i in range(1, n+1):
    glasses[i] = int(input())

dp = [0] * (n+1)
dp[1] = glasses[1]
if n > 1:
    dp[2] = glasses[1] + glasses[2]

for i in range(3, n + 1):
    dp[i] = max(dp[i-1], dp[i-2] + glasses[i], dp[i-3] + glasses[i-1] + glasses[i])
    
print(max(dp))
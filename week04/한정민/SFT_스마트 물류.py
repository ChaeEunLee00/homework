n, k = map(int, input().split())
data = list(input())
visited = [-1] * n

for i in range(n):
    if data[i] == 'H':
        visited[i] = 0

count = 0

for i in range(n):
    if data[i] == 'P':
        left = max(0, i - k)
        right = min(n, i + k + 1)
        for idx in range(left, right):
            if visited[idx] == 0 and data[idx] == 'H':
                visited[idx] = 1
                count += 1
                break

print(count)
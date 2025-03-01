import sys
input = sys.stdin.readline

n, d, k, c = map(int, input().split())
sushi = [int(input()) for _ in range(n)]
sushi.extend(sushi[:k-1])

i = 0
result = 0
while i < n:
    l = len(set(sushi[i:i+k]))
    if l == k:
        if c not in sushi[i:i+k]:
            result = max(result, k + 1)
            break
        else:
            result = max(result, k)

    if l < k:
        if c not in sushi[i:i+k]:
            result = max(result, l + 1)
        else:
            result = max(result, l)
    
    i += 1

print(result)
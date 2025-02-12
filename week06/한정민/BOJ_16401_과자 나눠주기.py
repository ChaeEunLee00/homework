import sys
input = sys.stdin.readline

m, n = map(int, input().split())
snacks = list(map(int, input().split()))

left = 1
right = max(snacks)

result = 0
while left <= right:
    total = 0
    mid = (left + right) // 2

    if sum([snack // mid for snack in snacks]) >= m:
        result = mid
        left = mid + 1
    else:
        right = mid - 1

print(result)
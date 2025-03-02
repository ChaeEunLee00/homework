n, m = map(int, input().split())
arr = list(map(int, input().split()))

start, end = 0, 0
count = 0

while end < n:
    if sum(arr[start:end+1]) < m:
        end += 1
    elif sum(arr[start:end+1]) > m:
        start += 1
    else:
        count += 1
        end += 1

print(count)
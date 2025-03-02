N, S = map(int, input().split())
data = list(map(int, input().split()))
length = N

start, end = 0, 0
total = data[0]
flag = False
while start <= end:
    if total >= S:
        flag = True
        length = min(length, end - start + 1)
        total -= data[start]
        start += 1
    else:
        end += 1
        if end == N:
            break
        total += data[end]

if flag:
    print(length)
else:
    print(0)
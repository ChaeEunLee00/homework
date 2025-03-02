n, k = map(int, input().split())
data = list(map(int, input().split()))

start, end = 0, 0
count = 0 # 홀수의 개수
answer = 0
while True:
    if count > k:
        if data[start] % 2 == 1:
            count -= 1
        start += 1
    elif end == n:
        break
    else:
        if data[end] % 2 == 1:
            count += 1
        end += 1
    
    if count <= k:
        answer = max(answer, end - start - count)

print(answer)
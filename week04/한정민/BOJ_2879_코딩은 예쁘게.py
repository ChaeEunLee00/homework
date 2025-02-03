n = int(input())
current = list(map(int, input().split()))
right = list(map(int, input().split()))

diff = [right[i] - current[i] for i in range(n)]

if n == 1:
    print(abs(diff[0]))
    
count = 0
prev = diff[0]

for i in range(1, n):
    if diff[i] >= 0:
        if prev < 0:
            count += abs(prev)
            prev = diff[i]
        elif prev < diff[i]:
            prev = diff[i]
        else:
            count += abs(prev) - abs(diff[i])
            prev = diff[i]
    else:
        if prev > 0:
            count += prev
            prev = diff[i]
        elif prev > diff[i]:
            prev = diff[i]
        else:
            count += abs(prev) - abs(diff[i])
            prev = diff[i]

count += abs(prev)
print(count)
N = int(input())
data = list(map(int, input().split()))
data.sort()

left, right = 0, N-1
answer = [0, 0]
temp = float('inf')

while left < right:
    if data[left] + data[right] < 0:
        if abs(data[left] + data[right]) < abs(temp):
            answer[0] = data[left]
            answer[1] = data[right]
            temp = data[left] + data[right]
        left += 1
    elif data[left] + data[right] > 0:
        if abs(data[left] + data[right]) < abs(temp):
            answer[0] = data[left]
            answer[1] = data[right]
            temp = data[left] + data[right]
        right -= 1
    else:
        answer[0] = data[left]
        answer[1] = data[right]
        break

print(answer[0], answer[1])
import sys

def binary_search(data, target):
    left = 0
    right = len(data) - 1
    while left <= right:
        mid = (left + right) // 2
        if data[mid] <= target:
            left = mid + 1
        else:
            right = mid - 1
    return len(data) - (right + 1)

input = input().split()
N, H = int(input[0]), int(input[1])
data_bottom = [] # 석순
data_top = [] # 종유석
for i in range(N):
    input = sys.stdin.readline().split()
    input_num = int(input[0])
    if i % 2 == 0:
        data_bottom.append(input_num)
    else:
        data_top.append(input_num)
data_bottom.sort()
data_top.sort()

answer = N
count = 0
for h in range(1, H + 1):
    bottom_cnt = binary_search(data_bottom, h - 1)
    top_cnt = binary_search(data_top, H - h)
    cur_cnt = bottom_cnt + top_cnt
    if cur_cnt < answer:
        answer = cur_cnt
        count = 1
    elif cur_cnt == answer:
        count += 1
print(answer, count)
import sys
input = sys.stdin.readline
n = int(input())

points = [list(map(int, input().split())) for _ in range(n)]
points.sort()

total = 0
i= 0
start_point = points[0][0]
end_point = points[0][1]

for i in range(1, n):
    if end_point >= points[i][0]:
        end_point = max(end_point, points[i][1])
    else:
        total += end_point - start_point
        start_point = points[i][0]
        end_point = points[i][1]

total += end_point - start_point
print(total)
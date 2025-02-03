import sys
input = sys.stdin.readline
t = int(input())
result = []

for _ in range(t):
    n = int(input())
    applicants = [tuple(map(int, input().split())) for _ in range(n)]
    applicants.sort()

    count = 1 # 첫번째 지원자는 무조건 선발
    best_rank = applicants[0][1]

    for i in range(1, n):
        if applicants[i][1] < best_rank:
            count += 1
            best_rank = applicants[i][1]
    print(count)